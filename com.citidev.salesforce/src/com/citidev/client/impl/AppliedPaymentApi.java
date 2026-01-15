package com.citidev.client.impl;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import com.citidev.client.api.ApiClientProvider;
import com.citidev.client.api.IApiClient;
import com.citidev.client.api.IAppliedPaymentApi;
import com.citidev.client.api.SalesforceEndpoints;
import com.citidev.client.dto.AppliedPaymentRawDTO;
import com.citidev.dto.AppliedPaymentDTO;
import com.citidev.services.transformers.AppliedPaymentTransformer;
import com.citidev.utilities.JsonUtils;

public class AppliedPaymentApi implements IAppliedPaymentApi{
	
	private final IApiClient apiClient;
    private static final String OBJECT_NAME = "Applied_Payment__c";
    public AppliedPaymentApi() {
        this.apiClient = ApiClientProvider.getApiClient();
    }

	@Override
	public List<AppliedPaymentRawDTO> getAllAppliedPayments() {
		// TODO Auto-generated method stub
		String soql = "SELECT Id, Name, LastModifiedDate FROM Applied_Payment__c limit 10";
   	 
    	String url = SalesforceEndpoints.QUERY.getUrl(URLEncoder.encode(soql, StandardCharsets.UTF_8));
    	String response = apiClient.queryAll(url);
        List<AppliedPaymentRawDTO> rawAccounts = JsonUtils.extractList(response, "records", AppliedPaymentRawDTO.class);
        return rawAccounts;
		
	}

	@Override
	public AppliedPaymentDTO getAppliedPaymentById(String id) {
		// TODO Auto-generated method stub
		 String response = apiClient.get("/services/data/v61.0/sobjects/Tower_Units__c/" + id);
	        AppliedPaymentRawDTO raw = JsonUtils.fromJson(response, AppliedPaymentRawDTO.class);
	        return AppliedPaymentTransformer.toDTO(raw);
		
	}

	@Override
	public void updateAccount(String id, Map<String, Object> data) {
		// TODO Auto-generated method stub
		String body = JsonUtils.toJson(data);
        apiClient.patch("/services/data/v61.0/sobjects/Tower_Units__c/" + id, body);
		
	}

}
