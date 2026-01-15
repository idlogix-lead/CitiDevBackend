package com.citidev.services;

import java.util.List;
import java.util.stream.Collectors;

import com.citidev.client.dto.InvoiceRawDTO;
import com.citidev.client.impl.AccountApi;
import com.citidev.client.impl.InvoiceApi;
import com.citidev.dto.InvoiceDTO;
import com.citidev.services.transformers.InvoiceTransformer;

public class InvoiceService {
	
	private final InvoiceApi invoiceApi;

    public InvoiceService() {
    	this.invoiceApi = new InvoiceApi();
    }

    public List<InvoiceDTO> getInvoices() {
        List<InvoiceRawDTO> rawAccounts = invoiceApi.getAllInvoices();
        return rawAccounts.stream()
                .map(InvoiceTransformer::toDTO)
                .collect(Collectors.toList());
    }

}
