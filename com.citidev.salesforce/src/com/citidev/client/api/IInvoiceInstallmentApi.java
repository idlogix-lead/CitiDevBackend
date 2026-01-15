package com.citidev.client.api;

import java.util.List;

import com.citidev.client.dto.InvoiceInstallmentRawDTO;
import com.citidev.dto.InvoiceInstallmentDTO;

public interface IInvoiceInstallmentApi {

	List<InvoiceInstallmentRawDTO> getAllInvoiceInstallments();
	InvoiceInstallmentDTO getInvoiceInstallmentById(String id);
}
