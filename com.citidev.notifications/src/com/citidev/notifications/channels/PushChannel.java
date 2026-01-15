package com.citidev.notifications.channels;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import org.adempiere.exceptions.AdempiereException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.compiere.model.MUser;
import org.compiere.model.Query;
import org.compiere.util.Env;

import com.citidev.models.MOneSignalConf;
import com.citidev.notifications.models.EmailNotificationPayload;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class PushChannel {

    private static final String ONESIGNAL_PUSH_URL =
            "https://api.onesignal.com/notifications";

    private String onesignalAppId;
    private String onesignalApiKey;

    private final ObjectMapper mapper = new ObjectMapper();

    public PushChannel() {
        MOneSignalConf conf = new Query(Env.getCtx(), MOneSignalConf.Table_Name, "", null).setClient_ID().setOnlyActiveRecords(true).first();
        loadOneSignalConfig(conf);
    }

    private void loadOneSignalConfig(MOneSignalConf config) {

        if (config == null) {
            throw new AdempiereException("OneSignal credentials missing/misconfigured");
        }

        this.onesignalAppId = config.getonesignal_appid();
        this.onesignalApiKey = config.getonesignal_email_api_key();

        if (onesignalAppId == null || onesignalApiKey == null ||
                onesignalAppId.isEmpty() || onesignalApiKey.isEmpty()) {
            throw new AdempiereException(
                    "OneSignal credentials missing/misconfigured");
        }
    }

    public void sendPaymentNotifications(List<EmailNotificationPayload> notifications) {
    	List<MUser> users = notifications.stream().map(obj -> obj.getUser()).collect(Collectors.toList());
        List<String> externalIds = users.stream()
                .map(user -> String.valueOf(user.get_ID()))
                .collect(Collectors.toList());
        if(users.size() == 0)
        	return;
        
        ObjectNode root = mapper.createObjectNode();
        root.put("app_id", onesignalAppId);

        ObjectNode headings = mapper.createObjectNode();
        headings.put("en", "Payment Reminder");
        root.set("headings", headings);

        ObjectNode contents = mapper.createObjectNode();
        contents.put("en", "Your payment is due soon. Please settle your invoice.");
        root.set("contents", contents);

        ArrayNode externalIdArray = mapper.createArrayNode();
        externalIds.forEach(externalIdArray::add);
        root.set("include_external_user_ids", externalIdArray);
        
        root.put("url", "");

        try {
            String payload = mapper.writeValueAsString(root);
            sendPush(payload);
        } catch (Exception e) {
            throw new AdempiereException(e.getMessage(), e);
        }
    }

    private void sendPush(String payload) {

        try (CloseableHttpClient client = HttpClients.createDefault()) {

            HttpPost post = new HttpPost(ONESIGNAL_PUSH_URL);
            post.setHeader("Content-Type", "application/json");
            post.setHeader("Authorization", "Basic " + onesignalApiKey);
            post.setEntity(new StringEntity(payload, StandardCharsets.UTF_8));

            CloseableHttpResponse response = client.execute(post);
            int status = response.getStatusLine().getStatusCode();

            if (status >= 200 && status < 300) {
                System.out.println("Push notifications sent successfully.");
            } else {
                String body = EntityUtils.toString(response.getEntity());
                throw new AdempiereException(
                        "OneSignal push API failed (HTTP " + status + "): " + body
                );
            }
        } catch (Exception e) {
            throw new AdempiereException(e.getMessage(), e);
        }
    }
}
