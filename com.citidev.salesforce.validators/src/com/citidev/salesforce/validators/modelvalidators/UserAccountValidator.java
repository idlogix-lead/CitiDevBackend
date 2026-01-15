package com.citidev.salesforce.validators.modelvalidators;

import org.compiere.model.MClient;
import org.compiere.model.MUser;
import org.compiere.model.ModelValidationEngine;
import org.compiere.model.ModelValidator;
import org.compiere.model.PO;

import com.citidev.dto.AccountDTO;
import com.citidev.services.AccountService;

public class UserAccountValidator implements ModelValidator {

	@Override
	public void initialize(ModelValidationEngine engine, MClient client) {
		// TODO Auto-generated method stub
		engine.addModelChange(MUser.Table_Name, this);
		
	}

	@Override
	public int getAD_Client_ID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String login(int AD_Org_ID, int AD_Role_ID, int AD_User_ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String modelChange(PO po, int type) throws Exception {
		// TODO Auto-generated method stub
		if(po.get_TableName().equals(MUser.Table_Name) && ( type == TYPE_AFTER_CHANGE )) {
			if(po.is_ValueChanged(MUser.COLUMNNAME_EMail) || po.is_ValueChanged(MUser.COLUMNNAME_Phone) || po.is_ValueChanged("residencecountry")) 
			{
				MUser user = (MUser) po;
				updateAccountOnSF(user);
			}
		}
		return null;
	}

	@Override
	public String docValidate(PO po, int timing) {
		// TODO Auto-generated method stub
		return null;
	}
	
	String updateAccountOnSF(MUser user) {
		AccountService accountService = new AccountService();
		AccountDTO dto = new AccountDTO();
		dto.setPersonEmail(user.getEMail());
		dto.setPersonMobilePhone(null);
		dto.setCountryOfResidence(user.get_ValueAsString("residencecountry"));
		
		accountService.updateAccount(user.get_ValueAsString("SF_AccountID"), dto);
		return null;
	}

}
