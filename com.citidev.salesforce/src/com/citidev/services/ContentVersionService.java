package com.citidev.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.compiere.model.MAttachment;
import org.compiere.model.MAttachmentEntry;
import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.util.Env;

import com.citidev.client.impl.ContentVersionApi;
import com.citidev.dto.ContentVersionDTO;

public class ContentVersionService {
	
	private final ContentVersionApi contentversionApi;


    public ContentVersionService() {
    	this.contentversionApi = new ContentVersionApi();
    }

    
    public ContentVersionDTO getContentDocumentById(String id) {
        return contentversionApi.getContentDocumentById(id);
    }
    public String createContentDocumentLink(Map<String,Object> fields) {
        return contentversionApi.createContentDocumentLink(fields);
    }
   
    
    public List<ContentVersionDTO> uploadFiles(int paymentId) {
    	List<ContentVersionDTO> uploadedFiles = new ArrayList<>();

        try {
            List<File> attachments = getPaymentAttachments(paymentId);
            if (attachments.isEmpty()) {
                throw new RuntimeException("No attachments found for Payment ID: " + paymentId);
            }

            for (File file : attachments) {
                String filePath = file.getAbsolutePath();
                String fileName = file.getName();

                System.out.println("Uploading file: " + fileName);

                // Read file bytes
                byte[] fileData = Files.readAllBytes(Paths.get(filePath));

                // Upload to Salesforce
                ContentVersionDTO result = contentversionApi.uploadFilesToSF(
                    fileName,       
                    filePath,       
                    fileData,       
                    fileName
                );

                if (result != null) {
                    uploadedFiles.add(result);
                    System.out.println("Uploaded: " + fileName + " → ID: " + result.getId());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to upload Payment attachments to Salesforce", e);
        }

        return uploadedFiles;
    }

    	
    public List<ContentVersionDTO> uploadFilesToSalesForce(int paymentId) {
    	List<ContentVersionDTO> uploadedList = uploadFiles(paymentId);
        List<ContentVersionDTO> resultList = new ArrayList<>();

        for (ContentVersionDTO uploaded : uploadedList) {
            if (uploaded != null && uploaded.getId() != null) {
                ContentVersionDTO dto = getContentDocumentById(uploaded.getId());
                System.out.println("Uploaded ContentVersion ID: " + dto.getContentdocumentId());
                resultList.add(dto);
            }
        }

        return resultList;
    }
    
    public void linkContentDocumentToRecord(String contentDocumentId, int paymentId) {
        try {
            String linkedEntityId = new Query(Env.getCtx(), "C_Payment", "C_Payment_ID=?", null)
                .setParameters(paymentId)
                .first()
                .get_ValueAsString("sf_uid");

            if (linkedEntityId == null || linkedEntityId.isEmpty()) {
                throw new RuntimeException("No Salesforce UID (sf_uid) found for Payment ID: " + paymentId);
            }
            
            Map<String, Object> fields = Map.of(
                "ContentDocumentId", contentDocumentId,
                "LinkedEntityId", linkedEntityId,
                "ShareType", "V" 
            );
            
            createContentDocumentLink(fields);

            System.out.println("Successfully linked ContentDocument " +contentDocumentId+ " to record " +linkedEntityId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to create ContentDocumentLink", e);
        }
    }
    
    private List<File> getPaymentAttachments(int paymentId) throws IOException {
        List<File> files = new ArrayList<>();

        int tableId = MTable.getTable_ID("C_Payment");
        MAttachment attachment = MAttachment.get(Env.getCtx(), tableId, paymentId);

        if (attachment == null) {
            System.out.println("No attachment found for Payment ID: " + paymentId);
            return files;
        }

        for (MAttachmentEntry entry : attachment.getEntries()) {
            File file = File.createTempFile("payment_", "_" + entry.getName());
            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write(entry.getData());
            }
            files.add(file);
        }

        return files;
    }



	



}
