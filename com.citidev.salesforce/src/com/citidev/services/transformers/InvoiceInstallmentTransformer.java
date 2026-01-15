package com.citidev.services.transformers;

import com.citidev.client.dto.InvoiceInstallmentRawDTO;
import com.citidev.dto.InvoiceInstallmentDTO;

/**
 * Transforms InvoiceInstallmentRawDTO (Salesforce raw model)
 * into InvoiceInstallmentDTO (domain composite model).
 */
public class InvoiceInstallmentTransformer {

    /**
     * Converts a raw Salesforce DTO to a domain DTO.
     *
     * @param raw the raw DTO returned from Salesforce
     * @return a mapped domain DTO (never null)
     */
    public static InvoiceInstallmentDTO toDTO(InvoiceInstallmentRawDTO raw) {
        if (raw == null) {
            return null;
        }

        InvoiceInstallmentDTO dto = new InvoiceInstallmentDTO();

        // --- Invoice Fields ---
        dto.setInvoiceId(raw.getInvoiceId());
        dto.setInvoiceName(raw.getInvoiceName());
        dto.setInvoiceDueDate(raw.getInvoiceDueDate());
        dto.setInvoiceDate(raw.getInvoiceDate());
        dto.setInvoiceAmount(raw.getInvoiceAmount());
        dto.setInvoiceOpportunity(raw.getInvoiceOpportunity());
        dto.setInvoiceAppliedAmount(raw.getInvoiceAppliedAmount());
        dto.setInvoiceUnappliedAmount(raw.getInvoiceUnappliedAmount());

        // --- Installment Fields ---
        dto.setInstallmentId(raw.getInstallmentId());
        dto.setInstallmentName(raw.getInstallmentName());
        dto.setInstallmentAmount(raw.getInstallmentAmount());
        dto.setInstallmentDate(raw.getInstallmentDate());
        dto.setInstallmentOpportunity(raw.getInstallmentOpportunity());
        dto.setInstallmentUnit(raw.getInstallmentUnit());
        dto.setInstallmentAccount(raw.getInstallmentAccount());
        dto.setInstallmentUnitId(raw.getInstallmentUnitId());
        dto.setInstallmentAllocatedAmount(raw.getInstallmentAllocatedAmount());
        dto.setInstallmentUnallocatedAmount(raw.getInstallmentUnallocatedAmount());

        return dto;
    }
}
