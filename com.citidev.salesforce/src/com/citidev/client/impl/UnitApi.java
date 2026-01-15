package com.citidev.client.impl;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import com.citidev.client.api.ApiClientProvider;
import com.citidev.client.api.IApiClient;
import com.citidev.client.api.SalesforceEndpoints;
import com.citidev.dto.UnitDTO;
import com.citidev.utilities.JsonUtils;

public class UnitApi {

    private static final String OBJECT_NAME = "Tower_Units__c";
    private static final String SELECT_FIELDS = 
        "SELECT Id, Name, Project_ID__c, Net_Total_Price__c, Unit_Status__c, Unit_Type__c, Unit_Usage__c, LastModifiedDate FROM " + OBJECT_NAME;

    private final IApiClient apiClient;

    public UnitApi() {
        this(ApiClientProvider.getApiClient());
    }

    public UnitApi(IApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public List<UnitDTO> fetchAllUnits() {
        String query = URLEncoder.encode(SELECT_FIELDS, StandardCharsets.UTF_8);
        String url = SalesforceEndpoints.QUERY.getUrl(query);
        String response = apiClient.queryAll(url);
        return JsonUtils.extractStandrdSFObjects(response, UnitDTO.class);
    }

    public void updateUnit(String id, Map<String, Object> fields) {
        String url = SalesforceEndpoints.UPDATE_OBJECT.getUrl(OBJECT_NAME, id);
        apiClient.patch(url, JsonUtils.toJson(fields));
    }
}

