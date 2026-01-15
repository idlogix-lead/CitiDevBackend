package com.citidev.infinity.processes;

import org.compiere.process.SvrProcess;
import com.citidev.services.OpportunityService;

@org.adempiere.base.annotation.Process
public class FetchOpportunityFromSalesForce extends SvrProcess {


    @Override
    protected void prepare() {
        // No parameters yet
    }

    @Override
    protected String doIt() throws Exception {

    	OpportunityService service = new OpportunityService();
    	int opportunity = service.syncOpportunitiesFromSalesforce();
    	return "opportunity synced successfully: "+opportunity ;
    }

}
