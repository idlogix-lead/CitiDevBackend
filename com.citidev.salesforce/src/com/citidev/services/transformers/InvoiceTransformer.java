package com.citidev.services.transformers;

import com.citidev.client.dto.InvoiceRawDTO;
import com.citidev.dto.InvoiceDTO;

public class InvoiceTransformer {
	
	 public static InvoiceDTO toDTO(InvoiceRawDTO raw) {
	        InvoiceDTO dto = new InvoiceDTO();

	        dto.setId(raw.getId());
	        dto.setName(raw.getName());
	        

	        return dto;
	    }

}
