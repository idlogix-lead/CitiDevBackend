package com.citidev.notifications.helpers;

import org.compiere.model.MSysConfig;

public class NotificationUtils {
	
	private static final String SYSCFG_ONESIGNAL_APIKEY = "ONESIGNAL_API_KEY_NOCACHE";
    private static final String SYSCFG_ONESIGNAL_APPID = "ONESIGNAL_APP_ID_NOCACHE";
	
	public static String getOneSignalEmailAppID() {
		return MSysConfig.getValue(SYSCFG_ONESIGNAL_APPID, "").trim();
	}
	
	public static String getOneSignalEmailApiKey() {
		return MSysConfig.getValue(SYSCFG_ONESIGNAL_APIKEY, "").trim();
	}

}
