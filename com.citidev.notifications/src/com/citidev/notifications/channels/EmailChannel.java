package com.citidev.notifications.channels;


import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class EmailChannel {

    private static final String ONESIGNAL_EMAIL_URL = "https://api.onesignal.com/notifications?c=email";
    private MOneSignalConf onesignalConf;
    String onesignalappid;
    String onesignalapikey;
    private final ObjectMapper mapper = new ObjectMapper();

    public EmailChannel() {
    	onesignalConf = new Query(Env.getCtx(), MOneSignalConf.Table_Name, "", (String)null).setClient_ID().setOnlyActiveRecords(true).first();
    	loadOneSignalConfig(onesignalConf);
    }
    
    private void loadOneSignalConfig(MOneSignalConf config) {
    	
    	if(config == null)
    		throw new AdempiereException("OneSignal Credentials Missing/MisConfigured in SysConfig");
    	
    	onesignalappid = config.getonesignal_appid();
    	onesignalapikey = config.getonesignal_email_api_key();

        if (onesignalappid.isEmpty() || onesignalapikey.isEmpty()) {
            throw new AdempiereException("OneSignal Credentials Missing/MisConfigured in SysConfig");
        }
    }
    
    public void sendPaymentNotifications(List<EmailNotificationPayload> notifications){
    	
    	List<MUser> users = notifications.stream().map(obj -> obj.getUser()).collect(Collectors.toList());
    	List<String> emails = notifications.stream()
    	        .map(obj -> obj.getUser())          
    	        .map(obj -> obj.getEMail())             
    	        .filter(Objects::nonNull)           
    	        .map(String::trim)                  
    	        .filter(email -> email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))
    	        .collect(Collectors.toList());
    	
    	if(emails.size() == 0)
    		return;
    	
    	ObjectNode root = mapper.createObjectNode();
        root.put("app_id", onesignalappid);
        root.put("email_subject", "Payment Reminder!");
        root.put("email_body", "<p>Your payment is due soon. Please settle your invoice.</p>");
        
        ArrayNode emailArray = mapper.createArrayNode();
        for (String email : emails) {
            emailArray.add(email);
        }
        root.set("email_to", emailArray);
        
        try {
			String json = mapper.writeValueAsString(root);
			sendEmail(json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    void sendEmail(String payload) {
    	String url = ONESIGNAL_EMAIL_URL;
    	try {
    		
    		CloseableHttpClient client = HttpClients.createDefault();
    		HttpPost post = new HttpPost(url);
            post.setHeader("Content-Type", "application/json");
            post.setHeader("Authorization", onesignalapikey);
            
            post.setEntity(new StringEntity(payload, StandardCharsets.UTF_8));
            
            CloseableHttpResponse response = client.execute(post);
            int status = response.getStatusLine().getStatusCode();

            if (status == 200) {
                System.out.println("Emails sent successfully.");
            } else {
                String body = EntityUtils.toString(response.getEntity());
                throw new AdempiereException(
                        "OneSignal email API failed (HTTP " + status + "): " + body
                );
            }
		} catch (Exception e) {
			// TODO: handle exception
		}
        
    }

}
