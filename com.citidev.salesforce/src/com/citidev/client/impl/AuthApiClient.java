package com.citidev.client.impl;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.citidev.client.api.IAuthApiClient;
import com.citidev.client.exception.AuthException;
import com.citidev.config.SFConfig;
import com.citidev.dto.AuthResponseDTO;
import com.citidev.utilities.JsonUtils;

public class AuthApiClient implements IAuthApiClient {

    private final SFConfig config;

    // Inject SFConfig (runtime credentials from DB)
    public AuthApiClient(SFConfig config) {
        this.config = config;
    }

    @Override
    public AuthResponseDTO authenticate() {
        try (CloseableHttpClient client = HttpClients.createDefault()) {

            String url = config.getBaseUrl() + "/services/oauth2/token";

            String body = "grant_type=client_credentials" +
                    "&client_id=" + URLEncoder.encode(config.getClientId(), StandardCharsets.UTF_8) +
                    "&client_secret=" + URLEncoder.encode(config.getClientSecret(), StandardCharsets.UTF_8);

            HttpPost post = new HttpPost(url);
            post.setHeader("Content-Type", "application/x-www-form-urlencoded");
            post.setEntity(new StringEntity(body));

            try (CloseableHttpResponse response = client.execute(post)) {
                int statusCode = response.getStatusLine().getStatusCode();
                String responseBody = EntityUtils.toString(response.getEntity());

                if (statusCode != 200) {
                    throw new AuthException("Failed to authenticate: " + responseBody);
                }

                return JsonUtils.fromJson(responseBody, AuthResponseDTO.class);
            }
        } catch (Exception e) {
            throw new AuthException("Error while authenticating with Salesforce", e);
        }
    }
}
