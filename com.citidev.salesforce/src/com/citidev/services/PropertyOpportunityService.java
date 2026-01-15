package com.citidev.services;

import java.util.List;
import java.util.stream.Collectors;

import com.citidev.client.dto.PropertyOpportunityRawDTO;
import com.citidev.client.impl.PropertyOpportunityApi;
import com.citidev.dto.PropertyOpportunityDTO;
import com.citidev.services.transformers.PropertyOpportunityTransformer;

public class PropertyOpportunityService {
	private final PropertyOpportunityApi opportunityApi;
	
	public PropertyOpportunityService() {
    	this.opportunityApi = new PropertyOpportunityApi();
    }
	
	 public List<PropertyOpportunityDTO> getOpportunitiess() {
	        List<PropertyOpportunityRawDTO> rawAccounts = opportunityApi.getAllOpportunities();
	        return rawAccounts.stream()
	                .map(PropertyOpportunityTransformer::toDTO)
	                .collect(Collectors.toList());
	    }

}
