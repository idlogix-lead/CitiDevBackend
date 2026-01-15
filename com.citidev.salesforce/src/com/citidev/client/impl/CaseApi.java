package com.citidev.client.impl;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.citidev.client.api.ApiClientProvider;
import com.citidev.client.api.IApiClient;
import com.citidev.client.api.ICaseAPI;
import com.citidev.client.api.SalesforceEndpoints;
import com.citidev.dto.CaseDTO;
import com.citidev.utilities.JsonUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CaseApi implements ICaseAPI {

    private final IApiClient apiClient;
    private static final Logger log = LoggerFactory.getLogger(CaseApi.class);
    private static final String OBJECT_NAME = "Case";
    private static final String STANDARD_SELECT = String.join(" ",
            "SELECT Id, CaseNumber, Subject, Status, Priority, LastModifiedDate FROM", OBJECT_NAME
    );

    public CaseApi() {
        this.apiClient = ApiClientProvider.getApiClient();
    }

    @Override
    public List<CaseDTO> getAllCases() {
        String query = buildSoqlQuery("");
        String url = SalesforceEndpoints.QUERY.getUrl(encode(query));
        String response = apiClient.queryAll(url);
        return JsonUtils.extractStandrdSFObjects(response, CaseDTO.class);
    }

    @Override
    public CaseDTO getCaseById(String id) {
        String url = SalesforceEndpoints.OBJECT_BY_ID.getUrl(OBJECT_NAME, id);
        String response = apiClient.get(url);
        return JsonUtils.fromJson(response, CaseDTO.class);
    }

    @Override
    public CaseDTO createCase(CaseDTO dto) {
        String url = SalesforceEndpoints.CREATE_OBJECT.getUrl(OBJECT_NAME);

        Map<String, Object> payload = new HashMap<>();
        if (dto.getSubject() != null) payload.put("Subject", dto.getSubject());
        if (dto.getPriority() != null) payload.put("Priority", dto.getPriority());
        if (dto.getStatus() != null) payload.put("Status", dto.getStatus());

        String body = JsonUtils.toJson(payload);

        log.info("[DEBUG] Sending POST to Salesforce URL:", url);
        log.info("[DEBUG] Request Body:", body);

        try {
            String response = apiClient.post(url, body);
            log.info("[DEBUG] Salesforce Response: {}", response);

            CaseDTO created = JsonUtils.fromJson(response, CaseDTO.class);
            JsonNode node = new ObjectMapper().readTree(response);
            if (node.has("id") && (created.getId() == null || created.getId().isEmpty())) {
                created.setId(node.get("id").asText());
            }

            return created;
        } catch (Exception e) {
            log.error("[ERROR] Salesforce POST failed for URL", url, e.getMessage(), e);
            return null;
        }
    }

    @Override
    public CaseDTO updateCase(String id, CaseDTO dto) {
        String url = SalesforceEndpoints.UPDATE_OBJECT.getUrl(OBJECT_NAME, id);
        String body = JsonUtils.toJson(dto);
        apiClient.patch(url, body);
        return dto;
    }

    @Override
    public void updateCase(String id, Map<String, Object> data) {
        String url = SalesforceEndpoints.UPDATE_OBJECT.getUrl(OBJECT_NAME, id);
        String body = JsonUtils.toJson(data);
        apiClient.patch(url, body);
    }

    @Override
    public boolean deleteCase(String id) {
        String url = SalesforceEndpoints.DELETE_OBJECT.getUrl(OBJECT_NAME, id);
        apiClient.delete(url);
        return true;
    }

    private String buildSoqlQuery(String filter) {
        return STANDARD_SELECT + (filter == null ? "" : filter);
    }

    private String encode(String value) {
        return URLEncoder.encode(value, StandardCharsets.UTF_8);
    }
}
