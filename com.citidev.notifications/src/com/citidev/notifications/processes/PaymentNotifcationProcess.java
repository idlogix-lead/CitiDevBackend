package com.citidev.notifications.processes;

import java.util.List;

import org.compiere.model.Query;
import org.compiere.process.SvrProcess;

import com.citidev.models.MNotificationPrefs;
import com.citidev.notifications.services.PaymentNotificationService;

@org.adempiere.base.annotation.Process
public class PaymentNotifcationProcess extends SvrProcess {

	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String doIt() throws Exception {
		// TODO Auto-generated method stub
		
		PaymentNotificationService pService = new PaymentNotificationService();
		pService.notifyUsersForPendingInstallments();
		
		return null;
	}
	
	List<MNotificationPrefs> getAllSUbscribedUsers(){
		return new Query(getCtx(), MNotificationPrefs.Table_Name, null, get_TrxName()).setOnlyActiveRecords(true).list();
	}
	

}
