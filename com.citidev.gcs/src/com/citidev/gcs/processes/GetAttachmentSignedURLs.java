package com.citidev.gcs.processes;

import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MAttachment;
import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import com.citidev.models.CDAttachmentEntry;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.HttpMethod;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

@org.adempiere.base.annotation.Process
public class GetAttachmentSignedURLs extends SvrProcess {

    private int adTableId;
    private String recordIdsCsv;

    private static final int URL_EXPIRY_MINUTES = 15;
    private static final String BUCKET = "cdsa-gcs-document-vault";

    private Storage storage;

    @Override
    protected void prepare() {
        ProcessInfoParameter[] params = getParameter();
        for (ProcessInfoParameter p : params) {
            if ("AD_Table_ID".equalsIgnoreCase(p.getParameterName())) {
                adTableId = p.getParameterAsInt();
            } else if ("Record_IDs".equalsIgnoreCase(p.getParameterName())) {
                recordIdsCsv = (String) p.getParameter();
            }
        }
    }

    @Override
    protected String doIt() throws Exception {

        if (adTableId <= 0 || recordIdsCsv == null || recordIdsCsv.isEmpty())
            return "{}";

        loadStorage();

        MTable table = MTable.get(getCtx(), adTableId,null);
        String tableName = table.getTableName();

        List<Integer> recordIds = parseRecordIds(recordIdsCsv);

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode root = mapper.createObjectNode();
        root.put("tableName", tableName);

        ArrayNode recordsNode = mapper.createArrayNode();

        for (Integer recordId : recordIds) {

            ObjectNode recordNode = mapper.createObjectNode();
            recordNode.put("recordId", recordId);

            ArrayNode attachmentsNode = mapper.createArrayNode();
            String filter = MAttachment.COLUMNNAME_AD_Table_ID + " = ? AND " + MAttachment.COLUMNNAME_Record_ID + " = ? ";
            List<MAttachment> attachments = new Query(getCtx(),MAttachment.Table_Name,filter,get_TrxName())
                    .setParameters(adTableId, recordId)
                    .setOnlyActiveRecords(true)
                    .list();

            for (MAttachment attachment : attachments) {

                ObjectNode attachmentNode = mapper.createObjectNode();
                attachmentNode.put("attachmentId", attachment.get_ID());

                ArrayNode filesNode = mapper.createArrayNode();
                String subFilter = CDAttachmentEntry.COLUMNNAME_AD_Attachment_ID + " = ? AND " + CDAttachmentEntry.COLUMNNAME_CD_GCS_UploadComplete + " = ? "; 
                List<CDAttachmentEntry> entries = new Query(getCtx(),CDAttachmentEntry.Table_Name,subFilter,get_TrxName())
                        .setParameters(attachment.get_ID(),"Y")
                        .list();

                for (CDAttachmentEntry entry : entries) {

                    ObjectNode fileNode = mapper.createObjectNode();
                    fileNode.put("id", entry.get_ID());
                    fileNode.put("name", entry.getName());
                    fileNode.put("mimeType", entry.getCD_GCS_MimeType());
                    fileNode.put("hash", entry.getCD_GCS_BlobHash());

                    String signedUrl =URLEncoder.encode(generateSignedUrl(entry), StandardCharsets.UTF_8);
                    fileNode.put("signedUrl", signedUrl);
                    fileNode.put("expiresInMinutes", URL_EXPIRY_MINUTES);

                    filesNode.add(fileNode);
                }

                attachmentNode.set("files", filesNode);
                attachmentsNode.add(attachmentNode);
            }

            recordNode.set("attachments", attachmentsNode);
            recordsNode.add(recordNode);
        }

        root.set("records", recordsNode);

        return mapper.writeValueAsString(root);
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

//    private void loadStorage() throws Exception {
//    	if (this.storage == null) {
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

    private String generateSignedUrl(CDAttachmentEntry entry) {

        BlobInfo blobInfo = BlobInfo.newBuilder(
                entry.getCD_GCS_BucketName(),
                entry.getCD_GCS_ObjectName()
        ).build();

        URL url = storage.signUrl(
                blobInfo,
                URL_EXPIRY_MINUTES,
                TimeUnit.MINUTES,
                Storage.SignUrlOption.withV4Signature(),
                Storage.SignUrlOption.httpMethod(HttpMethod.GET)
        );

        return url.toString();
    }

    private List<Integer> parseRecordIds(String csv) {
        List<Integer> ids = new ArrayList<>();
        for (String s : csv.split(",")) {
            try {
                ids.add(Integer.parseInt(s.trim()));
            } catch (NumberFormatException ignore) {
            }
        }
        return ids;
    }
}
