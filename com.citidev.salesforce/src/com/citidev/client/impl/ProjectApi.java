package com.citidev.client.impl;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
//import java.util.Map;

import com.citidev.client.api.ApiClientProvider;
import com.citidev.client.api.IApiClient;
import com.citidev.client.api.IProjectApi;
import com.citidev.client.api.SalesforceEndpoints;
import com.citidev.dto.ProjectDTO;
import com.citidev.utilities.JsonUtils;

public class ProjectApi implements IProjectApi {

    private final IApiClient apiClient;
    private static final String OBJECT_NAME = "Project__c"; 
    private static final String STANDARD_SELECT = String.join(" ",
            "SELECT Id, Name, Bank_name__c, Project_Location__c, LastModifiedDate FROM", OBJECT_NAME
    );

    public ProjectApi() {
        this.apiClient = ApiClientProvider.getApiClient();
    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        String query = buildSoqlQuery("");
        String url = SalesforceEndpoints.QUERY.getUrl(encode(query));
        String response = apiClient.queryAll(url);
        return JsonUtils.extractStandrdSFObjects(response, ProjectDTO.class);
    }

    @Override
    public ProjectDTO getProjectById(String id) {
        String url = SalesforceEndpoints.OBJECT_BY_ID.getUrl(OBJECT_NAME, id);
        String response = apiClient.get(url);
        return JsonUtils.fromJson(response, ProjectDTO.class);
    }
    
    public ProjectDTO updateProject(String id, ProjectDTO dto) {
    	 String url = SalesforceEndpoints.UPDATE_OBJECT.getUrl(OBJECT_NAME, id);
	        String body = JsonUtils.toJson(dto);
	        apiClient.patch(url, body);
	        return dto;
		
	}

    private String buildSoqlQuery(String filter) {
        return STANDARD_SELECT + (filter == null ? "" : filter);
    }

    private String encode(String value) {
        return URLEncoder.encode(value, StandardCharsets.UTF_8);
    }

	
}
