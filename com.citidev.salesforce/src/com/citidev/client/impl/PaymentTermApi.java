package com.citidev.client.impl;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import com.citidev.client.api.ApiClientProvider;
import com.citidev.client.api.IApiClient;
import com.citidev.client.api.IPaymentTermApi;
import com.citidev.client.api.SalesforceEndpoints;
import com.citidev.dto.PaymentTermDTO;
import com.citidev.utilities.JsonUtils;

public class PaymentTermApi implements IPaymentTermApi{
	
	private final IApiClient apiClient;
	 private static final String OBJECT_NAME = "Payment_Plan__C  ";
	    private static final String STANDARD_SELECT = String.join(" ",
	        "SELECT Id,Name,Payment_Plan_Name__c,CreatedDate,Down_payment__c,On_SPA_30_days_after_Booking__c,Number_of_Instalments_for_Pre_HO__c,Pre_HO_Instalment__c,On_HO_Instalment__c,Number_of_Instalments_for_Post_HO__c,Post_HO_Instalment__c,LastModifiedDate FROM ",
	        OBJECT_NAME, 
	        " limit 10");
	    public PaymentTermApi() {
	        this(ApiClientProvider.getApiClient());
	    }

	    public PaymentTermApi(IApiClient apiClient) {
	        this.apiClient = apiClient;
	    }

	@Override
	public List<PaymentTermDTO> getAllPaymentPlans() {
		// TODO Auto-generated method stub
		String query = buildSoqlQuery("");
        String url = SalesforceEndpoints.QUERY.getUrl(encode(query));
        String response = apiClient.queryAll(url);
        return JsonUtils.extractFlattenedList(response,"records", PaymentTermDTO.class);
	}

	@Override
	public PaymentTermDTO getPaymentPlanById(String id) {
		// TODO Auto-generated method stub
		String query = buildSoqlQuery("");
        String url = SalesforceEndpoints.OBJECT_BY_ID.getUrl(encode(query), OBJECT_NAME, id);
        String response = apiClient.get(url);
        return JsonUtils.fromJson(response, PaymentTermDTO.class);
	}
	
	@Override
	public void updatePaymentPlan(String id, Map<String, Object> fields) {
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
