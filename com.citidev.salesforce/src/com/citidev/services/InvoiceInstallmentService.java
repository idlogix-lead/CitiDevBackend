package com.citidev.services;

import java.util.List;
import java.util.stream.Collectors;

import com.citidev.client.dto.InvoiceInstallmentRawDTO;
import com.citidev.client.impl.InvoiceInstallmentApi;
import com.citidev.dto.InvoiceInstallmentDTO;
import com.citidev.services.transformers.InvoiceInstallmentTransformer;

public class InvoiceInstallmentService {

    private final InvoiceInstallmentApi invoiceInstallmentApi;

    public InvoiceInstallmentService() {
        this.invoiceInstallmentApi = new InvoiceInstallmentApi();
    }

    /**
     * Fetches all composite Installment + Invoice data and maps to DTO.
     */
    public List<InvoiceInstallmentDTO> getAllInvoiceInstallments() {
        List<InvoiceInstallmentRawDTO> rawList = invoiceInstallmentApi.getAllInvoiceInstallments();
        return rawList.stream()
                .map(InvoiceInstallmentTransformer::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Fetches a specific Installment + Invoice composite by ID.
     */
//    public InvoiceInstallmentDTO getInvoiceInstallmentById(String installmentId) {
//        List<InvoiceInstallmentRawDTO> rawList = invoiceInstallmentApi.getInvoiceInstallmentById(installmentId);
//        if (rawList != null && !rawList.isEmpty()) {
//            return InvoiceInstallmentTransformer.toDTO(rawList.get(0));
//        }
//        return null;
//    }
}

