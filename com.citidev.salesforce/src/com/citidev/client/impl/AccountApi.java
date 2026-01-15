package com.citidev.client.impl;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import com.citidev.client.api.ApiClientProvider;
import com.citidev.client.api.IApiClient;
import com.citidev.client.api.IUserApi;
import com.citidev.client.api.SalesforceEndpoints;
import com.citidev.dto.AccountDTO;
import com.citidev.utilities.JsonUtils;

public class AccountApi implements IUserApi {

    private final IApiClient apiClient;
    private static final String OBJECT_NAME = "Account";
    private static final String STANDARD_SELECT = String.join(" ",
            "SELECT Id, Name, FirstName, LastName, Nationality__c, Country_of_Residence__c,"
            + " Project_Name__c, PersonEmail, Phone, PersonMobilePhone, Passport_Number__c, LastModifiedDate FROM ",
	        OBJECT_NAME, 
	        " WHERE Passport_Number__c != null"
        );
    public AccountApi() {
        this.apiClient = ApiClientProvider.getApiClient();
    }

    @Override
    public List<AccountDTO> getAllAccounts() {
    	
    	 String query = buildSoqlQuery("");
         String url = SalesforceEndpoints.QUERY.getUrl(encode(query));
    	 String response = apiClient.queryAll(url);
         List<AccountDTO> rawAccounts = JsonUtils.extractList(response, "records", AccountDTO.class);
         return rawAccounts;
    }

    @Override
    public AccountDTO getAccountById(String id) {
    	String url = SalesforceEndpoints.OBJECT_BY_ID.getUrl(OBJECT_NAME, id);
        String response = apiClient.get(url);
        return JsonUtils.fromJson(response, AccountDTO.class);
    }

	@Override
	public void updateAccount(String id, Map<String, Object> fields) {
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

