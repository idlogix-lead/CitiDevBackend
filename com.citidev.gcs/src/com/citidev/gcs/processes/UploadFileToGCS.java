package com.citidev.gcs.processes;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;

import org.compiere.model.MAttachment;
import org.compiere.model.MAttachmentEntry;
import org.compiere.model.MProcessPara;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

@org.adempiere.base.annotation.Process
public class UploadFileToGCS extends SvrProcess {

    private int mTableID;
    private int mRecordID;

    @Override
    protected void prepare() {
        for (ProcessInfoParameter param : getParameter()) {
            if ("AD_Table_ID".equalsIgnoreCase(param.getParameterName())) {
                mTableID = param.getParameterAsInt();
            } 
            else if ("Record_ID".equalsIgnoreCase(param.getParameterName())) {
            	mRecordID = param.getParameterAsInt();
            }
            else {
                MProcessPara.validateUnknownParameter(getProcessInfo().getAD_Process_ID(), param);
            }
        }
    }

    @Override
    protected String doIt() throws Exception {

    	if(mTableID > 0 && mRecordID > 0) {
	    	GCSUploaderService service = new GCSUploaderService();
	    	service.syncAttachment(mTableID, mRecordID);
    	}
    	return null;
    }
}
