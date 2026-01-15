package com.citidev.infinity.processes;

import org.compiere.process.SvrProcess;
import com.citidev.services.InstallmentService;

@org.adempiere.base.annotation.Process
public class FetchInstallmentsFromSalesForce extends SvrProcess {


    @Override
    protected void prepare() {
        // No parameters yet
    }

    @Override
    protected String doIt() throws Exception {

    	InstallmentService service = new InstallmentService();
    	int installment = service.syncInstallmentsFromSalesforce();
//    	List<InstallmentDTO> dtos = service.getAllInstallments();
//    	 for (InstallmentDTO dto : dtos) {
//         	System.out.println(dto.getInstallmentdate());
//         }
    	return "Installments synced successfully: "+installment ;
//    	return null;
    }

}
