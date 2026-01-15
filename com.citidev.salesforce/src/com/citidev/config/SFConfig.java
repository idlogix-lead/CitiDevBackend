package com.citidev.config;

import com.citidev.models.MSFConfig;

public class SFConfig {

    private final String baseUrl;
    private final String clientId;
    private final String clientSecret;

    public SFConfig(MSFConfig credentials) {
        this.baseUrl = credentials.getinstanceurl();
        this.clientId = credentials.getclientid();
        this.clientSecret = credentials.getclientsecret();
    }

    public String getBaseUrl() {
        return baseUrl  ;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }
}

