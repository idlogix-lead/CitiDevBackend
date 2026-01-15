package com.citidev.client.impl;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import com.citidev.client.api.ApiClientProvider;
import com.citidev.client.api.IApiClient;
import com.citidev.client.api.IInstallmentApi;
import com.citidev.client.api.SalesforceEndpoints;
import com.citidev.dto.InstallmentDTO;
import com.citidev.utilities.JsonUtils;

public class InstallmentApi implements IInstallmentApi{
	
	private final IApiClient apiClient;
	 private static final String OBJECT_NAME = "Installment__c";
	    private static final String STANDARD_SELECT = String.join(" ",
	        "SELECT Id,UnallocatedAmount__c,Instalment_Date__c,Opportunity__c,Opportunity__r.AccountId,Unit__c,Opportunity__r.Payment_Plan__C,LastModifiedDate FROM ",
	        OBJECT_NAME, 
	        " WHERE UnallocatedAmount__c != null and Instalment_Date__c != null and Unit__c != null and Opportunity__r.AccountId != null");
	    public InstallmentApi() {
	        this(ApiClientProvider.getApiClient());
	    }

	    public InstallmentApi(IApiClient apiClient) {
	        this.apiClient = apiClient;
	    }

	@Override
	public List<InstallmentDTO> getAllInstallments() {
		// TODO Auto-generated method stub
		String query = buildSoqlQuery("");
        String url = SalesforceEndpoints.QUERY.getUrl(encode(query));
        String response = apiClient.queryAll(url);
        return JsonUtils.extractFlattenedList(response,"records", InstallmentDTO.class);
	}

	@Override
	public InstallmentDTO getInstallmentById(String id) {
		// TODO Auto-generated method stub
		String query = buildSoqlQuery("");
        String url = SalesforceEndpoints.OBJECT_BY_ID.getUrl(encode(query), OBJECT_NAME, id);
        String response = apiClient.get(url);
        return JsonUtils.fromJson(response, InstallmentDTO.class);
	}
	
	@Override
	public void updateInstallment(String id, Map<String, Object> fields) {
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
