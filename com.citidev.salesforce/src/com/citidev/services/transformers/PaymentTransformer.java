package com.citidev.services.transformers;



import com.citidev.client.dto.PaymentRawDTO;
import com.citidev.dto.PaymentDTO;



public class PaymentTransformer {
	
	public static PaymentDTO toDTO(PaymentRawDTO raw) {
        PaymentDTO dto = new PaymentDTO();

        dto.setId(raw.getId());
        dto.setName(raw.getName());
       

        return dto;
    }

}
