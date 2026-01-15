package com.citidev.notifications.processes;

import org.compiere.process.SvrProcess;
import com.citidev.notifications.services.ConstructionNotificationService;

@org.adempiere.base.annotation.Process
public class ConstructionNotifcationProcess extends SvrProcess {

	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String doIt() throws Exception {
		// TODO Auto-generated method stub

		ConstructionNotificationService pService = new ConstructionNotificationService();
		pService.sendNotification();
		return null;
	}
	
	

}
