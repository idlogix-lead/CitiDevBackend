package com.citidev.client.api;

import java.util.List;
import java.util.Map;

import com.citidev.client.dto.PropertyOpportunityRawDTO;
import com.citidev.dto.PropertyOpportunityDTO;

public interface IPropertyOpportunityApi {
	List<PropertyOpportunityRawDTO> getAllOpportunities();
    PropertyOpportunityDTO getAccountById(String id);
	void updatePropertyOpportunity(String id, Map<String, Object> fields);

}
