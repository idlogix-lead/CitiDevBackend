package com.citidev.notifications.models;

import java.util.List;

import org.compiere.model.MUser;

public class PushNotificationPayload {
	
	MUser user;
	String pushText;
	List<String> attachmentLinks;
	
	public PushNotificationPayload() {}

	public MUser getUser() {
		return user;
	}

	public void setUser(MUser user) {
		this.user = user;
	}

	public String getPushText() {
		return pushText;
	}

	public void setPushText(String pushText) {
		this.pushText = pushText;
	}

	public List<String> getAttachmentLinks() {
		return attachmentLinks;
	}

	public void setAttachmentLinks(List<String> attachmentLinks) {
		this.attachmentLinks = attachmentLinks;
	}
	
	
}
