package com.citidev.notifications.channels;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MUser;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.json.JSONObject;

import com.citidev.models.MTwilioConf;
import com.citidev.notifications.models.WhatsAppNotificationPayload;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class WhatsAppChannel {

    private MTwilioConf twilioConf;
    private static final String TEMPLATE_SID = "HX855b7e6e7074b67cdc795e5e8b343094";

    private final ExecutorService executor = Executors.newFixedThreadPool(5);

    private String accountSid;
    private String authToken;
    private String senderNumber;
    protected transient CLogger	log = CLogger.getCLogger (getClass());
    public WhatsAppChannel() {
    	twilioConf = new Query(Env.getCtx(), MTwilioConf.Table_Name, "", (String)null).setClient_ID().setOnlyActiveRecords(true).first();
    	loadTwilioConfig(twilioConf);
        Twilio.init(accountSid, authToken);
    }

    private void loadTwilioConfig(MTwilioConf config) {
    	
    	if(config == null)
    		throw new AdempiereException("Twilio Credentials Missing/MisConfigured in SysConfig");
    	
        accountSid = config.gettwilio_account_sid();
        authToken = config.gettwilio_auth_token();
        senderNumber = config.gettwilio_whatsapp_number();

        if (accountSid.isEmpty() || authToken.isEmpty() || !isValidE164(senderNumber)) {
            throw new AdempiereException("Twilio Credentials Missing/MisConfigured in SysConfig");
        }
    }

    public void sendPaymentReminderToUsers(List<WhatsAppNotificationPayload> notifications) {

        List<Future<?>> futures = new CopyOnWriteArrayList<>();

        for (WhatsAppNotificationPayload notification : notifications) {
            futures.add(
                executor.submit(() -> sendReminderToSingleUser(notification))
            );
        }

        waitForCompletion(futures);
    }

    private void sendReminderToSingleUser(WhatsAppNotificationPayload payload) {
    	MUser user = payload.getUser();
    	if(user == null)
    		return;
        try {
            String toPhone = user.getPhone().trim();

            if (!isValidE164(toPhone)) {
                System.err.println("Invalid phone number for user: " + user.getName());
                return;
            }

            PhoneNumber to = new PhoneNumber("whatsapp:" + toPhone);
            PhoneNumber from = new PhoneNumber("whatsapp:" + senderNumber);

            Map<String, Object> variables = new HashMap<>();
            variables.put("1", payload.getMessageText()); 

            Message message =
                Message.creator(to, from, (String) null)
                    .setContentSid(TEMPLATE_SID)
                    .setContentVariables(new JSONObject(variables).toString())
                    .create();

            System.out.println("Message sent to " + toPhone + " | SID: " + message.getSid());

        } catch (Exception ex) {
            System.err.println("Failed to send message to user " + user.getName() + ": " + ex.getMessage());
        }
    }


    private void waitForCompletion(List<Future<?>> futures) {
        for (Future<?> future : futures) {
            try {
                future.get(); 
            } catch (Exception ex) {
                System.err.println("Async task error: " + ex.getMessage());
            }
        }
    }

    public void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException ex) {
            executor.shutdownNow();
        }
    }

    private boolean isValidE164(String number) {
        return number != null && number.matches("^\\+[1-9]\\d{1,14}$");
    }
}
