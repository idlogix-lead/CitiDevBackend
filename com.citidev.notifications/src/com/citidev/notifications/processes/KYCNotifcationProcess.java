package com.citidev.notifications.processes;

import org.compiere.process.SvrProcess;
import com.citidev.notifications.services.KYCNotificationService;

@org.adempiere.base.annotation.Process
public class KYCNotifcationProcess extends SvrProcess {

	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String doIt() throws Exception {
		// TODO Auto-generated method stub
		
		KYCNotificationService pService = new KYCNotificationService();
		pService.sendNotification();
		
		
		return null;
	}
	
	
	

}
