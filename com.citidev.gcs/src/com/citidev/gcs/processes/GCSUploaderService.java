package com.citidev.gcs.processes;

import java.io.InputStream;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MAttachment;
import org.compiere.model.MAttachmentEntry;
import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import com.citidev.models.CDAttachmentEntry;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class GCSUploaderService {

    private Storage storage;
    private static final String BUCKET = "cdsa-gcs-document-vault";

    public GCSUploaderService() {
        loadStorage();
    }

    private void loadStorage() {
        if (this.storage == null) {
            try {
                storage = StorageOptions.getDefaultInstance().getService();
            } catch (Exception e) {
                throw new AdempiereException("Error initializing GCS storage: " + e.getMessage(), e);
            }
        }
    }

//    private void loadStorage() {
//        if (this.storage == null) {
//            try {
//                Bundle bundle = FrameworkUtil.getBundle(this.getClass());
//                URL keyURL = bundle.getEntry("credentials/cdsuperapp-d7c63fd59782.json");
//
//                if (keyURL == null)
//                    throw new AdempiereException("Credential file not found inside bundle!");
//
//                InputStream keyStream = keyURL.openStream();
//                storage = StorageOptions.newBuilder()
//                        .setCredentials(ServiceAccountCredentials.fromStream(keyStream))
//                        .build()
//                        .getService();
//            } catch (Exception e) {
//                throw new AdempiereException("Error initializing GCS storage: " + e.getMessage(), e);
//            }
//        }
//    }

    public void syncAttachment(int tableID, int recordID) {

        MTable table = new MTable(Env.getCtx(), tableID, null);
        if (table.get_ID() <= 0)
            return;

        String folderName = table.getName();
        String filter = MAttachment.COLUMNNAME_AD_Table_ID + " = ? " ;
        if(recordID> 0)
        	filter = filter + " AND " + MAttachment.COLUMNNAME_Record_ID + " = ? ";
        List<MAttachment> attachments = new Query(Env.getCtx(),MAttachment.Table_Name,filter,null)
                .setParameters(tableID, recordID)
                .setOnlyActiveRecords(true)
                .list();

        for (MAttachment attachment : attachments) {
            if (attachment.get_ID() <= 0)
                continue;

            /* ------------------------------------------------------------
             * 1. Load existing CDAttachmentEntry rows
             *    Keyed by filename (ONE row per filename)
             * ------------------------------------------------------------ */
            List<CDAttachmentEntry> dbEntries = new Query(Env.getCtx(),CDAttachmentEntry.Table_Name,CDAttachmentEntry.COLUMNNAME_AD_Attachment_ID + " = ? ",null)
                    .setParameters(attachment.get_ID())
                    .list();

            Map<String, CDAttachmentEntry> dbByFilename = new HashMap<>();
            for (CDAttachmentEntry e : dbEntries) {
                dbByFilename.put(e.getName(), e);
            }

            /* ------------------------------------------------------------
             * 2. Process current MAttachment entries (UPLOAD / UPDATE)
             * ------------------------------------------------------------ */
            Set<String> processedFilenames = new HashSet<>();

            for (MAttachmentEntry entry : attachment.getEntries()) {

                byte[] data = entry.getData();
                if (data == null || data.length == 0)
                    continue;

                String filename = entry.getName();
                String hash = computeSHA256(data);
                processedFilenames.add(filename);

                CDAttachmentEntry dbEntry = dbByFilename.get(filename);

                // CASE 1: Exists and unchanged → nothing to do
                if (dbEntry != null && hash.equals(dbEntry.getCD_GCS_BlobHash())) {
                    continue;
                }

                // CASE 2: Exists but changed → overwrite GCS + update row
                // CASE 3: New file → upload + insert row

                String gcsPath = folderName + "/" + attachment.get_ID() + "_" + filename;

                BlobId blobId = BlobId.of(BUCKET, gcsPath);
                BlobInfo blobInfo = BlobInfo.newBuilder(blobId)
                        .setContentType(entry.getContentType())
                        .build();

                // overwrite is intentional and correct
                storage.create(blobInfo, data);

                if (dbEntry == null) {
                    dbEntry = new CDAttachmentEntry(Env.getCtx(), 0, null);
                    dbEntry.setAD_Org_ID(attachment.getAD_Org_ID());
                    dbEntry.setAD_Attachment_ID(attachment.get_ID());
                    dbEntry.setName(filename);
                }

                dbEntry.setCD_GCS_BucketName(BUCKET);
                dbEntry.setCD_GCS_ObjectName(gcsPath);
                dbEntry.setCD_GCS_MimeType(entry.getContentType());
                dbEntry.setCD_GCS_GCSUtilURI("gs://" + BUCKET + "/" + gcsPath);
                dbEntry.setCD_GCS_BlobHash(hash);
                dbEntry.setCD_GCS_UploadComplete(true);
                dbEntry.setCD_GCS_DeleteComplete(true);

                dbEntry.saveEx();
            }

            /* ------------------------------------------------------------
             * 3. Delete removed files (DELETE)
             * ------------------------------------------------------------ */
            for (CDAttachmentEntry dbEntry : dbEntries) {

                // file no longer exists in MAttachment
                if (!processedFilenames.contains(dbEntry.getName())) {

                    try {
                        BlobId blobId = BlobId.of(
                                dbEntry.getCD_GCS_BucketName(),
                                dbEntry.getCD_GCS_ObjectName()
                        );
                        storage.delete(blobId);
                    } catch (Exception ex) {
                        // mark as pending delete and retry later
                        dbEntry.setCD_GCS_DeleteComplete(false);
                        dbEntry.saveEx();
                        continue;
                    }

                    dbEntry.deleteEx(true);
                }
            }
        }
    }



    private String computeSHA256(byte[] data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(data);
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 not available", e);
        }
    }
}
