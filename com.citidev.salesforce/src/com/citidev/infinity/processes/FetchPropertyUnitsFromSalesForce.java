package com.citidev.infinity.processes;


import org.compiere.model.MProcessPara;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;

import com.citidev.services.PropertyUnitService;

@org.adempiere.base.annotation.Process
public class FetchPropertyUnitsFromSalesForce extends SvrProcess {

	String mSFUID;
	
    @Override
    protected void prepare() {
    	for (ProcessInfoParameter param : getParameter()) {
            String name = param.getParameterName();
            if ("SF_UID".equalsIgnoreCase(name)) {
            	mSFUID = param.getParameterAsString();
            }
            else {
                MProcessPara.validateUnknownParameter(getProcessInfo().getAD_Process_ID(), param);
            }
        }
    }

    @Override
    protected String doIt() throws Exception {

    	PropertyUnitService service = new PropertyUnitService();
        service.syncUnitsFromSalesforce();
        
        return "Units synced successfully: " ;
    }


}
