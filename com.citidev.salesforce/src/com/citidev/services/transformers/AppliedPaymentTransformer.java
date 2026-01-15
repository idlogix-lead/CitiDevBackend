package com.citidev.services.transformers;

import com.citidev.client.dto.AppliedPaymentRawDTO;
import com.citidev.dto.AppliedPaymentDTO;

public class AppliedPaymentTransformer {
	
	 public static AppliedPaymentDTO toDTO(AppliedPaymentRawDTO raw) {
	        AppliedPaymentDTO dto = new AppliedPaymentDTO();

	        dto.setId(raw.getId());
	        dto.setName(raw.getName());
	       

	        return dto;
	    }

}
