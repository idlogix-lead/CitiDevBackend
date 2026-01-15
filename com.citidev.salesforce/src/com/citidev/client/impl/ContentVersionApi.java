package com.citidev.client.impl;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import com.citidev.client.api.ApiClientProvider;
import com.citidev.client.api.IApiClient;
import com.citidev.client.api.IContentVersionApi;
import com.citidev.client.api.SalesforceEndpoints;
import com.citidev.dto.ContentVersionDTO;
import com.citidev.utilities.JsonUtils;

public class ContentVersionApi implements IContentVersionApi{
	
	private final IApiClient apiClient;
	 private static final String OBJECT_NAME = "ContentVersion";
	 private static final String ContentDocumentLink = "ContentDocumentLink";
	    private static final String STANDARD_SELECT = String.join(" ",
	    		"SELECT ContentDocumentId FROM",OBJECT_NAME,"WHERE Id=");
	    public ContentVersionApi() {
	        this(ApiClientProvider.getApiClient());
	    }

	    public ContentVersionApi(IApiClient apiClient) {
	        this.apiClient = apiClient;
	    }


	@Override
	public ContentVersionDTO getContentDocumentById(String id) {
		// TODO Auto-generated method stub
		String query = buildSoqlQuery2(id);
        String url = SalesforceEndpoints.QUERY.getUrl(encode(query));
        String response = apiClient.queryAll(url);
        List<ContentVersionDTO> list = JsonUtils.extractFlattenedList(response, "records", ContentVersionDTO.class);
        return list.isEmpty() ? null : list.get(0);
	}
	
	@Override
	public ContentVersionDTO  uploadFilesToSF(String title, String pathOnClient, byte[] fileBytes, String fileName) {
		String url = SalesforceEndpoints.CREATE_OBJECT.getUrl(OBJECT_NAME);
		 // entity_content JSON
        String entityContent = JsonUtils.toJson(Map.of(
            "Title", title,
            "PathOnClient", pathOnClient,
            "ContentLocation","S"
        ));

        // Prepare multipart form data
        Map<String, Object> multipartData = Map.of(
            "entity_content", Map.of(
                "value", entityContent,
                "contentType", "application/json"
            ),
            "VersionData", Map.of(
                "value", fileBytes,
                "fileName", fileName,
                "contentType", "application/octet-stream"
            )
        );

        // Perform POST
        String response = apiClient.postMultipart(url, multipartData);

        // Parse and return created record
        return JsonUtils.fromJson(response, ContentVersionDTO.class);
    }
	
	public String createContentDocumentLink(Map<String,Object> fields) {
		String url = SalesforceEndpoints.CREATE_OBJECT.getUrl(ContentDocumentLink);
		 String body = JsonUtils.toJson(fields);
		 String response = apiClient.post(url, body);
		 return response;
		
	};
	
	
	private String buildSoqlQuery(String filter) {
        return STANDARD_SELECT + (filter == null ? "" : filter);
    }

    private String encode(String value) {
        return URLEncoder.encode(value, StandardCharsets.UTF_8);
    }
    private String buildSoqlQuery2(String filter) {
        return STANDARD_SELECT + (filter == null ? "" : "'" + filter + "'");
    }


}
