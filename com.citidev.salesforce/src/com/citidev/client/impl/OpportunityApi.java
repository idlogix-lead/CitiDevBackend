package com.citidev.client.impl;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import com.citidev.client.api.ApiClientProvider;
import com.citidev.client.api.IApiClient;
import com.citidev.client.api.IOpportunityApi;
import com.citidev.client.api.SalesforceEndpoints;
import com.citidev.dto.OpportunityDTO;
import com.citidev.utilities.JsonUtils;

public class OpportunityApi implements IOpportunityApi{
	
	private final IApiClient apiClient;
	 private static final String OBJECT_NAME = "Opportunity ";
	    private static final String STANDARD_SELECT = String.join(" ",
	        "SELECT Id,Name,AccountId,CloseDate,Tower_Unit__c,LastModifiedDate FROM ",
	        OBJECT_NAME, 
	        "  WHERE Tower_Unit__c != null limit 500");
	    public OpportunityApi() {
	        this(ApiClientProvider.getApiClient());
	    }

	    public OpportunityApi(IApiClient apiClient) {
	        this.apiClient = apiClient;
	    }

	@Override
	public List<OpportunityDTO> getAllOpportunities() {
		// TODO Auto-generated method stub
		String query = buildSoqlQuery("");
        String url = SalesforceEndpoints.QUERY.getUrl(encode(query));
        String response = apiClient.queryAll(url);
        return JsonUtils.extractFlattenedList(response,"records", OpportunityDTO.class);
	}

	@Override
	public OpportunityDTO getOpportunityById(String id) {
		// TODO Auto-generated method stub
		String query = buildSoqlQuery("");
        String url = SalesforceEndpoints.OBJECT_BY_ID.getUrl(encode(query), OBJECT_NAME, id);
        String response = apiClient.get(url);
        return JsonUtils.fromJson(response, OpportunityDTO.class);
	}
	
	@Override
	public void updateOpportunity(String id, Map<String, Object> fields) {
		String url = SalesforceEndpoints.UPDATE_OBJECT.getUrl(OBJECT_NAME, id);
        String body = JsonUtils.toJson(fields);
        apiClient.patch(url, body);
    }

	
	private String buildSoqlQuery(String filter) {
        return STANDARD_SELECT + (filter == null ? "" : filter);
    }

    private String encode(String value) {
        return URLEncoder.encode(value, StandardCharsets.UTF_8);
    }

}
