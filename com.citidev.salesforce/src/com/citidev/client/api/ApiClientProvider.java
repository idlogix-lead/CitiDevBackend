package com.citidev.client.api;

import org.compiere.model.Query;
import org.compiere.util.Env;

import com.citidev.client.impl.ApiClient;
import com.citidev.client.impl.AuthApiClient;
import com.citidev.config.SFConfig;
import com.citidev.models.MSFConfig;


public class ApiClientProvider {
    private static ApiClient apiClient;

    // Lazily initialize on first access
    public static synchronized ApiClient getApiClient() {
        if (apiClient == null) {
            // Fetch credentials from DB
            MSFConfig creds = new Query(Env.getCtx(), MSFConfig.Table_Name, "IsActive='Y'", null)
                    .setClient_ID()   // optional: limit to tenant
                    .first();

            if (creds == null) {
                throw new IllegalStateException("No active Salesforce config found in DB");
            }

            SFConfig sfConfig = new SFConfig(creds);
            AuthApiClient authApiClient = new AuthApiClient(sfConfig);
            apiClient = new ApiClient(authApiClient);
        }
        return apiClient;
    }
}



