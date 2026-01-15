package com.citidev.notifications.services;

import java.math.BigDecimal;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MUser;
import org.compiere.util.DB;
import org.compiere.util.Env;

import com.citidev.models.MNotificationPrefs;
import com.citidev.notifications.channels.EmailChannel;
import com.citidev.notifications.channels.WhatsAppChannel;
import com.citidev.notifications.models.EmailNotificationPayload;
import com.citidev.notifications.models.PushNotificationPayload;
import com.citidev.notifications.models.WhatsAppNotificationPayload;


public class PaymentNotificationService {

	private WhatsAppChannel whatsappChannel;
	private EmailChannel emailChannel;
	public static final String SIMPLE_WHATSAPP_TEMPLATE = "Dear %s, Your installments of amount %s is pending.";
	public static final String SIMPLE_EMAIL_SUBJECT_TEMPLATE = "Property Installments Due!";

	public PaymentNotificationService() {
		this.whatsappChannel = new WhatsAppChannel();
		this.emailChannel = new EmailChannel();
	}
	
	
    public void  notifyUsersForPendingInstallments() {
    	
    	List<PaymentNotificationContext> subscriptions = getSubscriptions();
    	List<WhatsAppNotificationPayload> whatsAppNotifications = new ArrayList<WhatsAppNotificationPayload>();
    	List<EmailNotificationPayload> emailNotifications = new ArrayList<EmailNotificationPayload>();
    	List<PushNotificationPayload> pushNotifications = new ArrayList<PushNotificationPayload>();
    	
    	for(PaymentNotificationContext subscription : subscriptions) 
    	{
    		boolean isEligible = isToBeNotifiedToday(subscription.getInvoiceDates(), subscription.getPrefs());
    		
    		if(isEligible) {
    			MUser user = subscription.getUser();
    			MNotificationPrefs prefs = subscription.getPrefs();
        		if(prefs.ispayment_whatsapp()) {
        			WhatsAppNotificationPayload waPayload = new WhatsAppNotificationPayload();
        			waPayload.setUser(user);
        			waPayload.setMessageText(getSimpleWhatsAppText(subscription.getUser(), new BigDecimal (100)));
        			whatsAppNotifications.add(waPayload);
        		}
        		if(prefs.ispayment_email()) {
        			EmailNotificationPayload emailPayload = new EmailNotificationPayload();
        			emailPayload.setUser(user);
        			emailPayload.setEmailSubject(getSimpleEmailSubject());
        			emailPayload.setEmailBody(getSimpleWhatsAppText(subscription.getUser(), new BigDecimal (100)));
        			emailNotifications.add(emailPayload);
        		}        			
        		if(prefs.ispayment_push()) {
        			PushNotificationPayload pushPayload = new PushNotificationPayload();
        			pushPayload.setPushText(getSimpleWhatsAppText(subscription.getUser(), new BigDecimal (100)));
        			pushNotifications.add(pushPayload);
        		}
        			
    		}

    	}
    	
    	this.whatsappChannel.sendPaymentReminderToUsers(whatsAppNotifications);
    	this.emailChannel.sendPaymentNotifications(emailNotifications);
    	
    	
    }

    boolean isToBeNotifiedToday(List<Timestamp> dates, MNotificationPrefs prefs) {
    	
    	if(prefs.ispayment_daily_until_paid())
    		return true;
    	LocalDate today = (new Timestamp(System.currentTimeMillis())).toLocalDateTime().toLocalDate();
    	
    	boolean isLess = dates.stream()
    		    .map(ts -> ts.toLocalDateTime().toLocalDate())
    		    .anyMatch(date -> today.isBefore(date));
    	
    	if(prefs.ispayment_one_day_before_due() && isLess)
    		return true;
    	
    	boolean isMatch = dates.stream()
    		    .map(ts -> ts.toLocalDateTime().toLocalDate())
    		    .anyMatch(date -> date.equals(today));

    	
    	if(prefs.ispayment_on_billing_date() && isMatch)
    		return true;
    	return false;
    }
    
    

    List<PaymentNotificationContext> getSubscriptions(){
    	
    	List<PaymentNotificationContext> data = new ArrayList<PaymentNotificationContext>();
    	
    	 String sql = "select u.ad_user_id,np.cd_notifications_prefs_id, COALESCE(array_agg(DISTINCT v.dateinvoiced ORDER BY v.dateinvoiced), '{}') AS invoice_dates, SUM(openamt) openamt "
    			+ "from citidev_custinstall_summary_v v "
    			+ "join ad_user u ON v.c_bpartner_id = u.c_bpartner_id "
    			+ "join cd_notifications_prefs np ON u.ad_user_id = np.ad_user_id "
    			+ "where coalesce(invoiceamt,0) - coalesce(openamt,0) > 0 "
    			+ "AND (np.payment_push = 'Y' OR np.payment_email = 'Y' OR payment_whatsapp = 'Y') "
    			+ "group by u.ad_user_id,np.cd_notifications_prefs_id "
    			+ "order by u.ad_user_id ";
    	
    	 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 Properties ctx = Env.getCtx();
		 
		 try
			{
			pstmt = DB.prepareStatement(sql.toString(), null);
			rs = pstmt.executeQuery();
			while (rs.next())
				{
					MUser user = new MUser(ctx, rs.getInt("AD_User_ID"), null);
					MNotificationPrefs prefs = new MNotificationPrefs(ctx, rs.getInt("cd_notifications_prefs_id"),null);
					Array sqlArray = rs.getArray("invoice_dates");
					
					List<Timestamp> invoiceDates;
					if (sqlArray == null) {
					    invoiceDates = new ArrayList<>();
					} else {
					    Timestamp[] tsArray = (Timestamp[]) sqlArray.getArray();
					    invoiceDates = Arrays.asList(tsArray);
					}
					data.add(new PaymentNotificationContext(user, prefs, invoiceDates));
				}
			}
		catch (Exception e)
		{
			throw new AdempiereException(e);
		}
		finally
		{
			DB.close(rs, pstmt);
			rs = null;
			pstmt = null;
		}
    	
		 return data;
    	
    }
    
    
    String getSimpleWhatsAppText(MUser user, BigDecimal amt) {
    	String customerName = user.get_ValueAsString("FullName");
    	customerName = customerName == null || customerName.trim().isEmpty() ? "Customer" : customerName; 
//    	return String.format(SIMPLE_WHATSAPP_TEMPLATE, customerName,amt);
    	return customerName;
    }
    
    String getSimpleEmailSubject() {
    	return SIMPLE_EMAIL_SUBJECT_TEMPLATE;
    }
    
    String getSimpleEmailBody(MUser user, BigDecimal amt) {
    	String customerName = user.get_ValueAsString("FullName");
    	customerName = customerName == null || customerName.trim().isEmpty() ? "Customer" : customerName; 
    	return String.format(SIMPLE_WHATSAPP_TEMPLATE, customerName,amt);
    }
    
    String getSimplePushBody(MUser user, BigDecimal amt) {
    	String customerName = user.get_ValueAsString("FullName");
    	customerName = customerName == null || customerName.trim().isEmpty() ? "Customer" : customerName; 
    	return String.format(SIMPLE_WHATSAPP_TEMPLATE, customerName,amt);
    }
    
  
    public static class PaymentNotificationContext {
        private MUser user;
        private MNotificationPrefs prefs;
        private List<Timestamp> invoiceDates;

        public PaymentNotificationContext(MUser user, MNotificationPrefs prefs, List<Timestamp> scheduleTimes) {
            this.user = user;
            this.prefs = prefs;
            this.invoiceDates = scheduleTimes;
        }

		public MUser getUser() {
			return user;
		}

		public void setUser(MUser user) {
			this.user = user;
		}

		public MNotificationPrefs getPrefs() {
			return prefs;
		}

		public void setPrefs(MNotificationPrefs prefs) {
			this.prefs = prefs;
		}

		public List<Timestamp> getInvoiceDates() {
			return invoiceDates;
		}

		public void setInvoiceDates(List<Timestamp> invoiceDates) {
			this.invoiceDates = invoiceDates;
		}
   
    }
    
    
    
}

