package com.citidev.client.impl;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import com.citidev.client.api.ApiClientProvider;
import com.citidev.client.api.IApiClient;
import com.citidev.client.api.IBuildingApi;
import com.citidev.client.api.SalesforceEndpoints;
import com.citidev.dto.BuildingDTO;
import com.citidev.utilities.JsonUtils;

public class BuildingApi implements IBuildingApi {
	
	
	
	private final IApiClient apiClient;
    private static final String OBJECT_NAME = "Tower__c";
    private static final String STANDARD_SELECT = String.join(" ",
            "SELECT Id, Name, Project_Type__c, Service_Level__c, LastModifiedDate FROM ", OBJECT_NAME
        );
    public BuildingApi() {
        this.apiClient = ApiClientProvider.getApiClient();
    }

	@Override
	public List<BuildingDTO> getAllBuildings() {
		String query = buildSoqlQuery("");
        String url = SalesforceEndpoints.QUERY.getUrl(encode(query));
        String response = apiClient.queryAll(url);
        return JsonUtils.extractStandrdSFObjects(response, BuildingDTO.class);
	}

	@Override
	public BuildingDTO getBuildingById(String id) {
		String query = buildSoqlQuery("");
        String url = SalesforceEndpoints.OBJECT_BY_ID.getUrl(encode(query), OBJECT_NAME, id);
        String response = apiClient.get(url);
        return JsonUtils.fromJson(response, BuildingDTO.class);
	}

	@Override
	public void updateBuilding(String id, Map<String, Object> data) {
		 String url = SalesforceEndpoints.UPDATE_OBJECT.getUrl(OBJECT_NAME, id);
        String body = JsonUtils.toJson(data);
        apiClient.patch(url, body);
	}
	
	  private String buildSoqlQuery(String filter) {
	        return STANDARD_SELECT + (filter == null ? "" : filter);
	    }

	    private String encode(String value) {
	        return URLEncoder.encode(value, StandardCharsets.UTF_8);
	    }

}
