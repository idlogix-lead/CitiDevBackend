package com.citidev.notifications.models;

import java.util.List;

import org.compiere.model.MUser;

public class EmailNotificationPayload {
	
	MUser user;
	String emailSubject;
	String emailBody;
	List<String> attachmentLinks;
	
	public EmailNotificationPayload() {}

	public MUser getUser() {
		return user;
	}

	public void setUser(MUser user) {
		this.user = user;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public String getEmailBody() {
		return emailBody;
	}

	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}

	public List<String> getAttachmentLinks() {
		return attachmentLinks;
	}

	public void setAttachmentLinks(List<String> attachmentLinks) {
		this.attachmentLinks = attachmentLinks;
	}
	
	

}
