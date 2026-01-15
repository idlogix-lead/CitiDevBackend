package com.citidev.infinity.processes;

import org.compiere.process.SvrProcess;

import com.citidev.services.CaseService;

@org.adempiere.base.annotation.Process
public class FetchCaseFromSalesForce extends SvrProcess{

	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String doIt() throws Exception {
		 CaseService service = new CaseService();
	        int fromCount = service.syncCasesFromSalesforce();
	        int toCount = service.syncCasesToSalesforce();
	        return "Sync Complete: " + fromCount + " cases fetched from Salesforce to ERP, and " 
	             + toCount + " cases pushed from ERP to Salesforce.";
	}
	
	

}
