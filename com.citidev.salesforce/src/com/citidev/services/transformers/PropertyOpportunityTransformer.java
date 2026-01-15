package com.citidev.services.transformers;

import com.citidev.client.dto.PropertyOpportunityRawDTO;
import com.citidev.dto.PropertyOpportunityDTO;

public class PropertyOpportunityTransformer {
	
	public static PropertyOpportunityDTO toDTO(PropertyOpportunityRawDTO raw){
		PropertyOpportunityDTO dto = new PropertyOpportunityDTO();

        dto.setId(raw.getId());
        dto.setName(raw.getName());
        dto.setStageName(raw.getStageName());
        dto.setSales_Offer_Response(raw.getSales_Offer_Response());
        dto.setOpportunity_Unique_Identifier(raw.getOpportunity_Unique_Identifier__c());

        return dto;
    }

}
