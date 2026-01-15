package com.citidev.infinity.processes;

import org.compiere.process.SvrProcess;
import com.citidev.services.ReceiptService;

@org.adempiere.base.annotation.Process
public class FetchReceiptFromSalesForce extends SvrProcess {
	
    @Override
    protected void prepare() {
        // no parameters
    }

    @Override
    protected String doIt() throws Exception {
        ReceiptService service = new ReceiptService();
        int receiptfromscount = service.syncReceiptsFromSalesforce();
        int receipttoscount = service.syncReceiptsToSalesforce();
        return "Receipts synchronized successfully. From SF: " +receiptfromscount + "Receipts synchronized successfully. To SF:" +receipttoscount;
       
        
        
        
    }
}
