package com.citidev.client.impl;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import com.citidev.client.api.ApiClientProvider;
import com.citidev.client.api.IApiClient;
import com.citidev.client.api.IInvoiceApi;
import com.citidev.client.api.SalesforceEndpoints;
import com.citidev.client.dto.InvoiceRawDTO;
import com.citidev.client.dto.PropertyUnitRawDTO;
import com.citidev.dto.InvoiceDTO;
import com.citidev.services.transformers.InvoiceTransformer;
import com.citidev.utilities.JsonUtils;

public class InvoiceApi implements IInvoiceApi{
	
	private final IApiClient apiClient;
    private static final String OBJECT_NAME = " Invoice__c";
    public InvoiceApi() {
        this.apiClient = ApiClientProvider.getApiClient();
    }

	@Override
	public List<InvoiceRawDTO> getAllInvoices() {
		// TODO Auto-generated method stub
		String soql = "SELECT Id, Name, Account__c, DueDate__c, InvoiceDate__c, Installment__c, " +
	              "InvoiceAmount__c, Opportunity__c, Unit__c, AppliedAmount__c, LastModifiedDate FROM Invoice__c";

   	 
    	String url = SalesforceEndpoints.QUERY.getUrl(URLEncoder.encode(soql, StandardCharsets.UTF_8));
    	String response = apiClient.queryAll(url);
        List<InvoiceRawDTO> rawAccounts = JsonUtils.extractList(response, "records", InvoiceRawDTO.class);
        return rawAccounts;
		
	}

	@Override
	public InvoiceDTO getInvoiceById(String id) {
		// TODO Auto-generated method stub
		 String response = apiClient.get("/services/data/v61.0/sobjects/Tower_Units__c/" + id);
	        InvoiceRawDTO raw = JsonUtils.fromJson(response, InvoiceRawDTO.class);
	        return InvoiceTransformer.toDTO(raw);
		
	}

	@Override
	public void updateAccount(String id, Map<String, Object> data) {
		// TODO Auto-generated method stub
		String body = JsonUtils.toJson(data);
        apiClient.patch("/services/data/v61.0/sobjects/Tower_Units__c/" + id, body);
		
	}

}
