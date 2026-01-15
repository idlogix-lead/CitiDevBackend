package com.citidev.client.impl;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.citidev.client.api.IApiClient;
import com.citidev.client.api.IAuthApiClient;
import com.citidev.client.exception.ApiException;
import com.citidev.dto.AuthResponseDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ApiClient implements IApiClient {

    private final CloseableHttpClient httpClient;
    private final IAuthApiClient authApiClient;

    private String accessToken;
    private String instanceUrl;

    public ApiClient(IAuthApiClient authApiClient) {
        this.httpClient = HttpClients.createDefault();
        this.authApiClient = authApiClient;
        initToken();
    }

    private synchronized void initToken() {
        AuthResponseDTO authResponse = authApiClient.authenticate();
        this.accessToken = authResponse.getAccess_token();
        this.instanceUrl = authResponse.getInstance_url();
    }

    private void addAuthHeader(HttpRequestBase request) {
        request.setHeader("Authorization", "Bearer " + accessToken);
    }

    private String executeWithRetry(HttpRequestBase request) {
        try (var response = httpClient.execute(request)) {
            int statusCode = response.getStatusLine().getStatusCode();
            String responseBody = response.getEntity() != null
                    ? EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8)
                    : "";

            if (statusCode == 401) {
                // token expired → refresh and retry once
                initToken();
                addAuthHeader(request);
                try (var retryResponse = httpClient.execute(request)) {
                    int retryStatus = retryResponse.getStatusLine().getStatusCode();
                    String retryBody = retryResponse.getEntity() != null
                            ? EntityUtils.toString(retryResponse.getEntity(), StandardCharsets.UTF_8)
                            : "";
                    if (retryStatus >= 200 && retryStatus < 300) {
                        return retryBody;
                    }
                    throw new ApiException("Retry after re-auth failed: " + retryBody, null);
                }
            }

            if (statusCode >= 200 && statusCode < 300) {
                return responseBody;
            }

            throw new ApiException("Request failed with status " + statusCode + ": " + responseBody, null);

        } catch (Exception e) {
            throw new ApiException("Error executing request: " + request.getURI(), e);
        }
    }

    @Override
    public String get(String endpoint) {
        HttpGet request = new HttpGet(instanceUrl + endpoint);
        addAuthHeader(request);
        return executeWithRetry(request);
    }

    @Override
    public String post(String endpoint, String body) {
        HttpPost request = new HttpPost(instanceUrl + endpoint);
        addAuthHeader(request);
        if (body != null) {
            request.setEntity(new StringEntity(body, StandardCharsets.UTF_8));
            request.setHeader("Content-Type", "application/json");
        }
        return executeWithRetry(request);
    }

    @Override
    public String patch(String endpoint, String body) {
        HttpPatch request = new HttpPatch(instanceUrl + endpoint);
        addAuthHeader(request);
        if (body != null) {
            request.setEntity(new StringEntity(body, StandardCharsets.UTF_8));
            request.setHeader("Content-Type", "application/json");
        }
        return executeWithRetry(request);
    }

    @Override
    public void delete(String endpoint) {
        HttpDelete request = new HttpDelete(instanceUrl + endpoint);
        addAuthHeader(request);
        executeWithRetry(request);
    }
    
    public String queryAll(String soqlOrEndpoint) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode allRecords = mapper.createArrayNode();

        // Determine if input is full endpoint or just SOQL
        String nextUrl = soqlOrEndpoint.startsWith("/services/data")
                ? soqlOrEndpoint
                : "/services/data/v61.0/query?q=" + soqlOrEndpoint;

        int totalSize = 0;
        boolean done = false;

        while (true) {
            String response = get(nextUrl);
            try {
                JsonNode root = mapper.readTree(response);

                // Append records
                JsonNode records = root.get("records");
                if (records != null && records.isArray()) {
                    Iterator<JsonNode> it = records.elements();
                    while (it.hasNext()) {
                        allRecords.add(it.next());
                    }
                    totalSize += records.size();
                }

                // Check pagination
                done = root.path("done").asBoolean();
                if (!done && root.has("nextRecordsUrl")) {
                    nextUrl = root.get("nextRecordsUrl").asText();
                } else {
                    break;
                }

            } catch (Exception e) {
                throw new ApiException("Error parsing Salesforce query response", e);
            }
        }

        // Build a Salesforce-style response structure
        ObjectNode result = mapper.createObjectNode();
        result.put("totalSize", totalSize);
        result.put("done", true);
        result.set("records", allRecords);

        try {
            return mapper.writeValueAsString(result);
        } catch (Exception e) {
            throw new ApiException("Error serializing combined response", e);
        }
    }
    
    @Override
    public String postMultipart(String endpoint, Map<String, Object> multipartData) {
        String boundary = "----SalesforceBoundary" + UUID.randomUUID();
        String lineFeed = "\r\n";
        HttpURLConnection conn = null;

        try {
            URL url = new URL(instanceUrl + endpoint);
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer " + accessToken);
            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

            try (OutputStream outputStream = conn.getOutputStream();
                 DataOutputStream writer = new DataOutputStream(outputStream)) {

                for (Map.Entry<String, Object> entry : multipartData.entrySet()) {
                    String fieldName = entry.getKey();
                    @SuppressWarnings("unchecked")
					Map<String, Object> part = (Map<String, Object>) entry.getValue();

                    Object value = part.get("value");
                    String contentType = (String) part.get("contentType");
                    String fileName = (String) part.get("fileName");

                    writer.writeBytes("--" + boundary + lineFeed);
                    writer.writeBytes("Content-Disposition: form-data; name=\"" + fieldName + "\"");

                    if (fileName != null) {
                        writer.writeBytes("; filename=\"" + fileName + "\"");
                    }
                    writer.writeBytes(lineFeed);
                    writer.writeBytes("Content-Type: " + contentType + lineFeed);
                    writer.writeBytes(lineFeed);

                    if (value instanceof byte[]) {
                        writer.write((byte[]) value);
                    } else {
                        writer.writeBytes(value.toString());
                    }
                    writer.writeBytes(lineFeed);
                }

                writer.writeBytes("--" + boundary + "--" + lineFeed);
                writer.flush();
            }

            int status = conn.getResponseCode();
            InputStream responseStream = (status >= 200 && status < 300)
                    ? conn.getInputStream()
                    : conn.getErrorStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(responseStream));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            return response.toString();

        } catch (Exception e) {
            throw new RuntimeException("Multipart POST failed: " + e.getMessage(), e);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

}
