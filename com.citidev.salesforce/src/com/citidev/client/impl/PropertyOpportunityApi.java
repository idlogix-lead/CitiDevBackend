package com.citidev.client.impl;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import com.citidev.client.api.ApiClientProvider;
import com.citidev.client.api.IApiClient;
import com.citidev.client.api.IPropertyOpportunityApi;
import com.citidev.client.api.SalesforceEndpoints;
import com.citidev.client.dto.PropertyOpportunityRawDTO;
import com.citidev.dto.PropertyOpportunityDTO;
import com.citidev.services.transformers.PropertyOpportunityTransformer;
import com.citidev.utilities.JsonUtils;

public class PropertyOpportunityApi implements IPropertyOpportunityApi {
	
	private final IApiClient apiClient;
    private static final String OBJECT_NAME = "Opportunity";
    public PropertyOpportunityApi() {
        this.apiClient = ApiClientProvider.getApiClient();
    }

	@Override
	public List<PropertyOpportunityRawDTO> getAllOpportunities() {
		// TODO Auto-generated method stub
		String soql = "SELECT Id, Name, StageName, Sales_Offer_Response, Opportunity_Unique_Identifier, LastModifiedDate FROM Opportunity limit 10";
   	 
    	String url = SalesforceEndpoints.QUERY.getUrl(URLEncoder.encode(soql, StandardCharsets.UTF_8));
    	String response = apiClient.queryAll(url);
        List<PropertyOpportunityRawDTO> rawAccounts = JsonUtils.extractList(response, "records", PropertyOpportunityRawDTO.class);
        return rawAccounts;
	}

	@Override
	public PropertyOpportunityDTO getAccountById(String id) {
		// TODO Auto-generated method stub
		String response = apiClient.get("/services/data/v61.0/sobjects/Tower_Units__c/" + id);
        PropertyOpportunityRawDTO raw = JsonUtils.fromJson(response, PropertyOpportunityRawDTO.class);
        return PropertyOpportunityTransformer.toDTO(raw);
	}

	@Override
	public void updatePropertyOpportunity(String id, Map<String, Object> fields) {
		// TODO Auto-generated method stub
		String body = JsonUtils.toJson(fields);
        apiClient.patch("/services/data/v61.0/sobjects/Tower_Units__c/" + id, body);
	}
	
	

}
