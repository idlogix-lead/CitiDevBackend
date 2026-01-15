package com.citidev.client.impl;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import com.citidev.client.api.ApiClientProvider;
import com.citidev.client.api.IApiClient;
import com.citidev.client.api.IAppliedReceiptApi;
import com.citidev.client.api.SalesforceEndpoints;
import com.citidev.client.dto.AppliedReceiptRawDTO;
import com.citidev.client.dto.PropertyUnitRawDTO;
import com.citidev.dto.AppliedReceiptDTO;
import com.citidev.services.transformers.AppliedReceiptTransformer;
import com.citidev.utilities.JsonUtils;

public class AppliedReceiptApi implements IAppliedReceiptApi{
	
	private final IApiClient apiClient;
    private static final String OBJECT_NAME = "Applied_Receipt__c";
    public AppliedReceiptApi() {
        this.apiClient = ApiClientProvider.getApiClient();
    }

	@Override
	public List<AppliedReceiptRawDTO> getAllAppliedReceipts() {
		// TODO Auto-generated method stub
		String soql = "SELECT Id, Name, LastModifiedDate FROM Applied_Receipt__c limit 10";
   	 
    	String url = SalesforceEndpoints.QUERY.getUrl(URLEncoder.encode(soql, StandardCharsets.UTF_8));
    	String response = apiClient.queryAll(url);
        List<AppliedReceiptRawDTO> rawAccounts = JsonUtils.extractList(response, "records", AppliedReceiptRawDTO.class);
        return rawAccounts;
	
	}

	@Override
	public AppliedReceiptDTO getAppliedReceiptById(String id) {
		// TODO Auto-generated method stub
		 String response = apiClient.get("/services/data/v61.0/sobjects/Tower_Units__c/" + id);
	        AppliedReceiptRawDTO raw = JsonUtils.fromJson(response, AppliedReceiptRawDTO.class);
	        return AppliedReceiptTransformer.toDTO(raw);
		
	}

	@Override
	public void updateAccount(String id, Map<String, Object> data) {
		// TODO Auto-generated method stub
		String body = JsonUtils.toJson(data);
        apiClient.patch("/services/data/v61.0/sobjects/Tower_Units__c/" + id, body);
		
	}

}
