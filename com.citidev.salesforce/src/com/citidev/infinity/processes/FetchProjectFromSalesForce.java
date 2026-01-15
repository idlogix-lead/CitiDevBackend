package com.citidev.infinity.processes;


import org.compiere.process.SvrProcess;

import com.citidev.services.ProjectService;

@org.adempiere.base.annotation.Process
public class FetchProjectFromSalesForce extends SvrProcess {

	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String doIt() throws Exception {
		// TODO Auto-generated method stub
		ProjectService service = new ProjectService();
    	int pcount = service.syncedProjectsFromSalesForce();
    	return "Projects successfully synced" + pcount;
	}
}
