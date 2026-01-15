package com.citidev.infinity.processes;

import java.util.List;

import org.compiere.process.SvrProcess;

import com.citidev.dto.BuildingDTO;
import com.citidev.services.AccountService;
import com.citidev.services.BuildingService;

@org.adempiere.base.annotation.Process
public class FetchUserAccountFromSalesForce extends SvrProcess {

    @Override
    protected void prepare() {
        // No parameters yet
    }

    @Override
    protected String doIt() throws Exception {
    	
    	AccountService service = new AccountService();
    	int syncedCount = service.syncAccountsFromSalesforce();
    	return "User synced successfully: "+syncedCount ;
    }
}
