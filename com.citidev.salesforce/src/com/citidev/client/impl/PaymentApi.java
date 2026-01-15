package com.citidev.client.impl;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import com.citidev.client.api.ApiClientProvider;
import com.citidev.client.api.IApiClient;
import com.citidev.client.api.IPaymentApi;
import com.citidev.client.api.SalesforceEndpoints;
import com.citidev.client.dto.PaymentRawDTO;
import com.citidev.client.dto.PropertyUnitRawDTO;
import com.citidev.dto.PaymentDTO;
import com.citidev.services.transformers.AppliedPaymentTransformer;
import com.citidev.services.transformers.PaymentTransformer;
import com.citidev.utilities.JsonUtils;

public class PaymentApi implements IPaymentApi{
	
	private final IApiClient apiClient;
    private static final String OBJECT_NAME = "Payment__c";
    public PaymentApi() {
        this.apiClient = ApiClientProvider.getApiClient();
    }

	@Override
	public List<PaymentRawDTO> getAllPayments() {
		// TODO Auto-generated method stub
		String soql = "SELECT Id, Name, LastModifiedDate FROM Payment__c limit 10";
   	 
    	String url = SalesforceEndpoints.QUERY.getUrl(URLEncoder.encode(soql, StandardCharsets.UTF_8));
    	String response = apiClient.queryAll(url);
        List<PaymentRawDTO> rawAccounts = JsonUtils.extractList(response, "records", PaymentRawDTO.class);
        return rawAccounts;
		
	}

	@Override
	public PaymentDTO getPaymentById(String id) {
		// TODO Auto-generated method stub
		 String response = apiClient.get("/services/data/v61.0/sobjects/Tower_Units__c/" + id);
	        PaymentRawDTO raw = JsonUtils.fromJson(response, PaymentRawDTO.class);
	        return PaymentTransformer.toDTO(raw);
			
		
	}

	@Override
	public void updateAccount(String id, Map<String, Object> data) {
		// TODO Auto-generated method stub
		String body = JsonUtils.toJson(data);
        apiClient.patch("/services/data/v61.0/sobjects/Tower_Units__c/" + id, body);
	}

}
