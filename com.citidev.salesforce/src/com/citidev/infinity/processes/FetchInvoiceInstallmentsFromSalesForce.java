package com.citidev.infinity.processes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.compiere.process.SvrProcess;
import com.citidev.dto.InvoiceInstallmentDTO;
import com.citidev.services.InvoiceInstallmentService;

@org.adempiere.base.annotation.Process
public class FetchInvoiceInstallmentsFromSalesForce extends SvrProcess {

    private Map<String, Integer> prodMap = new HashMap<>();
    private Map<Integer, Integer> userRoleMap = new HashMap<>();

    @Override
    protected void prepare() {
        // No parameters yet
    }

    @Override
    protected String doIt() throws Exception {

        InvoiceInstallmentService pInstallmentService = new InvoiceInstallmentService();
        List<InvoiceInstallmentDTO> units = pInstallmentService.getAllInvoiceInstallments();

        int success = 0;
        int created = 0;
        int updated = 0;

        for (InvoiceInstallmentDTO dto : units) {
        	System.out.println(dto.getInstallmentDate());
        }

        return String.format(
                "Import Completed. Success: %d / Total: %d (Created: %d, Updated: %d)",
                success, units.size(), created, updated);
    }


}
