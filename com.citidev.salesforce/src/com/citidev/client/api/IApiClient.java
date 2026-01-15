package com.citidev.client.api;

import java.util.Map;

public interface IApiClient {
    String get(String endpoint);
    String post(String endpoint, String body);
    String patch(String endpoint, String body);
    void delete(String endpoint);
    String queryAll(String endpoint);
    String postMultipart(String endpoint, Map<String, Object> multipartData);

}

