package com.citidev.notifications.models;

import java.util.List;

import org.compiere.model.MSysConfig;
import org.compiere.model.MUser;
import org.compiere.util.Env;

public class WhatsAppNotificationPayload {
	
	MUser user;
	String messageText;
	String senderPhoneNum;
	String messageID;
	List<String> attachmentLinks;
	
	
	public WhatsAppNotificationPayload() {
		
	}

	public MUser getUser() {
		return user;
	}

	public void setUser(MUser user) {
		this.user = user;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public String getSenderPhoneNum() {
		return senderPhoneNum;
	}

	public void setSenderPhoneNum(String senderPhoneNum) {
		this.senderPhoneNum = senderPhoneNum;
	}

	public String getMessageID() {
		return messageID;
	}

	public void setMessageID(String messageID) {
		this.messageID = messageID;
	}

	public List<String> getAttachmentLinks() {
		return attachmentLinks;
	}

	public void setAttachmentLinks(List<String> attachmentLinks) {
		this.attachmentLinks = attachmentLinks;
	}

	
}
