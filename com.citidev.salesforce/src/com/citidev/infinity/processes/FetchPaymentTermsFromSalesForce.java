package com.citidev.infinity.processes;

import org.compiere.process.SvrProcess;
import com.citidev.services.PaymentTermService;

@org.adempiere.base.annotation.Process
public class FetchPaymentTermsFromSalesForce extends SvrProcess {


    @Override
    protected void prepare() {
        // No parameters yet
    }

    @Override
    protected String doIt() throws Exception {

    	PaymentTermService service = new PaymentTermService();
    	int paymentTerm = service.syncPaymentPlansFromSalesforce();
    	return "Payment Terms synced successfully: "+paymentTerm ;
//    	return null;
    }

}
