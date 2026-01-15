package com.citidev.client.impl;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import com.citidev.client.api.ApiClientProvider;
import com.citidev.client.api.IApiClient;
import com.citidev.client.api.IPropertyUnitApi;
import com.citidev.client.api.SalesforceEndpoints;
//import com.citidev.client.dto.PropertyUnitRawDTO;
import com.citidev.dto.PropertyUnitDTO;
import com.citidev.utilities.JsonUtils;

public class PropertyUnitApi implements IPropertyUnitApi {

    private static final String OBJECT_NAME = "Tower_Units__c";
    private static final String STANDARD_SELECT = String.join(" ",
        "SELECT Id, Name, Project_ID__c, Net_Total_Price__c,",
        "Unit_Status__c, Unit_Type__c, Unit_Usage__c FROM", OBJECT_NAME
    );

    private final IApiClient apiClient;

    public PropertyUnitApi() {
        this.apiClient = ApiClientProvider.getApiClient();
    }

    @Override
    public List<PropertyUnitDTO> getAllPropertyUnits() {
        String query = buildSoqlQuery("");
        String url = SalesforceEndpoints.QUERY.getUrl(encode(query));
        String response = apiClient.queryAll(url);
        return JsonUtils.extractStandrdSFObjects(response, PropertyUnitDTO.class);
    }

    @Override
    public PropertyUnitDTO getPropertyUnitById(String id) {
        String url = SalesforceEndpoints.OBJECT_BY_ID.getUrl(OBJECT_NAME, id);
        String response = apiClient.get(url);
        return JsonUtils.fromJson(response, PropertyUnitDTO.class);
    }

    @Override
    public void updatePropertyUnit(String id, Map<String, Object> fields) {
        String url = SalesforceEndpoints.UPDATE_OBJECT.getUrl(OBJECT_NAME, id);
        String body = JsonUtils.toJson(fields);
        apiClient.patch(url, body);
    }
    
    public void createPropertyUnit(Map<String, Object> fields) {
        String url = SalesforceEndpoints.CREATE_OBJECT.getUrl(OBJECT_NAME);
        String body = JsonUtils.toJson(fields);
        apiClient.post(url, body);
    }
    


    private String buildSoqlQuery(String filter) {
        return STANDARD_SELECT + (filter == null ? "" : filter);
    }

    private String encode(String value) {
        return URLEncoder.encode(value, StandardCharsets.UTF_8);
    }

	

	

	
}
