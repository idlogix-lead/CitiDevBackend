package com.citidev.notifications.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.compiere.model.MUser;
import org.compiere.model.Query;
import org.compiere.util.Env;

import com.citidev.models.MNotificationPrefs;
import com.citidev.notifications.channels.EmailChannel;
import com.citidev.notifications.channels.WhatsAppChannel;
import com.citidev.notifications.models.EmailNotificationPayload;
import com.citidev.notifications.models.PushNotificationPayload;
import com.citidev.notifications.models.WhatsAppNotificationPayload;

public class ConstructionNotificationService {
	
	private WhatsAppChannel whatsappChannel;
	private EmailChannel emailChannel;
	public static final String SIMPLE_WHATSAPP_TEMPLATE = "Dear %s, Your KYC is pending!";
	public static final String SIMPLE_EMAIL_SUBJECT_TEMPLATE = "KYC Pending";

	public ConstructionNotificationService() {
		this.whatsappChannel = new WhatsAppChannel();
		this.emailChannel = new EmailChannel();
	}
    
	public void sendNotification(){
		
		List<MNotificationPrefs> subscriptions = getSubscriptions();
		List<WhatsAppNotificationPayload> whatsAppNotifications = new ArrayList<WhatsAppNotificationPayload>();
    	List<EmailNotificationPayload> emailNotifications = new ArrayList<EmailNotificationPayload>();
    	List<PushNotificationPayload> pushNotifications = new ArrayList<PushNotificationPayload>();
		
    	for(MNotificationPrefs subscription : subscriptions) {
    		MUser user = (MUser) subscription.getAD_User();
    		if(subscription.ispayment_whatsapp()) {
    			WhatsAppNotificationPayload waPayload = new WhatsAppNotificationPayload();
    			waPayload.setUser(user);
    			waPayload.setMessageText(getSimpleWhatsAppText(user, new BigDecimal (100)));
    			whatsAppNotifications.add(waPayload);
    		}
    		if(subscription.ispayment_email()) {
    			EmailNotificationPayload emailPayload = new EmailNotificationPayload();
    			emailPayload.setUser(user);
    			emailPayload.setEmailSubject(getSimpleEmailSubject());
    			emailPayload.setEmailBody(getSimpleWhatsAppText(user, new BigDecimal (100)));
    			emailNotifications.add(emailPayload);
    		}        			
    		if(subscription.ispayment_push()) {
    			PushNotificationPayload pushPayload = new PushNotificationPayload();
    			pushPayload.setPushText(getSimpleWhatsAppText(user, new BigDecimal (100)));
    			pushNotifications.add(pushPayload);
    		}
    		
		}
		
    	this.whatsappChannel.sendPaymentReminderToUsers(whatsAppNotifications);
    	this.emailChannel.sendPaymentNotifications(emailNotifications);
		
		
	}
	
	String getSimpleWhatsAppText(MUser user, BigDecimal amt) {
    	String customerName = user.get_ValueAsString("FullName");
    	customerName = customerName == null || customerName.trim().isEmpty() ? "Customer" : customerName; 
    	return String.format(SIMPLE_WHATSAPP_TEMPLATE, customerName);
    }
    
    String getSimpleEmailSubject() {
    	return SIMPLE_EMAIL_SUBJECT_TEMPLATE;
    }
    
    String getSimpleEmailBody(MUser user, BigDecimal amt) {
    	String customerName = user.get_ValueAsString("FullName");
    	customerName = customerName == null || customerName.trim().isEmpty() ? "Customer" : customerName; 
    	return String.format(SIMPLE_WHATSAPP_TEMPLATE, customerName);
    }
    
    String getSimplePushBody(MUser user, BigDecimal amt) {
    	String customerName = user.get_ValueAsString("FullName");
    	customerName = customerName == null || customerName.trim().isEmpty() ? "Customer" : customerName; 
    	return String.format(SIMPLE_WHATSAPP_TEMPLATE, customerName);
    }

  
    
    List<MNotificationPrefs> getSubscriptions(){

    	String filter = MNotificationPrefs.COLUMNNAME_construction_email + " 'Y' " + " OR " +
    					MNotificationPrefs.COLUMNNAME_construction_whatsapp + " 'Y' " + " OR " +
    					MNotificationPrefs.COLUMNNAME_construction_push + " 'Y' ";
    	
    	return new Query(Env.getCtx(), MNotificationPrefs.Table_Name, filter, null).setOnlyActiveRecords(true).list();
    	
    }    
    
}

