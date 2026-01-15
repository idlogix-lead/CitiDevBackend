package com.citidev.infinity.processes;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.compiere.process.SvrProcess;

import com.citidev.dto.ContentVersionDTO;
import com.citidev.services.ContentVersionService;

@org.adempiere.base.annotation.Process
public class FetchContentVersionFromSalesForce extends SvrProcess {


    @Override
    protected void prepare() {
        // No parameters yet
    }

    @Override
    protected String doIt() throws Exception {
        int paymentId = getRecord_ID();
        if (paymentId <= 0) {
            return "No Payment record selected.";
        }

    	ContentVersionService service = new ContentVersionService();
//    	
    	List<ContentVersionDTO> content_version = service.uploadFilesToSalesForce(paymentId);
    	if (content_version == null || content_version.isEmpty()) {
    	    return "No files were uploaded to Salesforce.";
    	}
//    	for linking documentid to entity id:
//    	for (ContentVersionDTO dto  : content_version) {
//    		String contentDocId = dto.getContentdocumentId();
//			service.linkContentDocumentToRecord(contentDocId, paymentId);
//		}

    	String allIds = content_version.stream()
    	    .map(ContentVersionDTO::getContentdocumentId)
    	    .filter(Objects::nonNull)
    	    .collect(Collectors.joining(", "));

    	return "Files uploaded successfully to Salesforce. Created Content Document IDs: " + allIds;

//    	return null;
    }

}
