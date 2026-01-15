package com.citidev.models;

import java.sql.ResultSet;
import java.util.Properties;

public class OneSignalConf extends X_CD_OneSignal_Conf{

	public OneSignalConf(Properties ctx, int CD_OneSignal_Conf_ID, String trxName, String... virtualColumns) {
		super(ctx, CD_OneSignal_Conf_ID, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public OneSignalConf(Properties ctx, int CD_OneSignal_Conf_ID, String trxName) {
		super(ctx, CD_OneSignal_Conf_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public OneSignalConf(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public OneSignalConf(Properties ctx, String CD_OneSignal_Conf_UU, String trxName, String... virtualColumns) {
		super(ctx, CD_OneSignal_Conf_UU, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public OneSignalConf(Properties ctx, String CD_OneSignal_Conf_UU, String trxName) {
		super(ctx, CD_OneSignal_Conf_UU, trxName);
		// TODO Auto-generated constructor stub
	}

}
