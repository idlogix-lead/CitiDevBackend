package com.citidev.client.api;

import java.util.List;
import java.util.Map;
import com.citidev.client.dto.InvoiceRawDTO;
import com.citidev.dto.InvoiceDTO;

public interface IInvoiceApi {
	
	 List<InvoiceRawDTO> getAllInvoices();
	    InvoiceDTO getInvoiceById(String id);
	    void updateAccount(String id,Map<String,Object> data);

}
