package com.citidev.services.transformers;

import com.citidev.client.dto.AppliedReceiptRawDTO;
import com.citidev.dto.AppliedReceiptDTO;

public class AppliedReceiptTransformer {
	
	 public static AppliedReceiptDTO toDTO(AppliedReceiptRawDTO raw) {
	        AppliedReceiptDTO dto = new AppliedReceiptDTO();

	        dto.setId(raw.getId());
	        dto.setName(raw.getName());

	        return dto;
	    }

}
