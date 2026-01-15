package com.citidev.models;

import java.sql.ResultSet;
import java.util.Properties;

public class MNotificationPrefs extends X_CD_Notifications_Prefs{

	public MNotificationPrefs(Properties ctx, int CD_Notifications_Prefs_ID, String trxName, String... virtualColumns) {
		super(ctx, CD_Notifications_Prefs_ID, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MNotificationPrefs(Properties ctx, int CD_Notifications_Prefs_ID, String trxName) {
		super(ctx, CD_Notifications_Prefs_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MNotificationPrefs(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MNotificationPrefs(Properties ctx, String CD_Notifications_Prefs_UU, String trxName,
			String... virtualColumns) {
		super(ctx, CD_Notifications_Prefs_UU, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MNotificationPrefs(Properties ctx, String CD_Notifications_Prefs_UU, String trxName) {
		super(ctx, CD_Notifications_Prefs_UU, trxName);
		// TODO Auto-generated constructor stub
	}

}
