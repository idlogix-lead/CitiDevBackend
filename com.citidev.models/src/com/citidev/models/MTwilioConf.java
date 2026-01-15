package com.citidev.models;

import java.sql.ResultSet;
import java.util.Properties;

public class MTwilioConf extends X_CD_Twilio_Conf{

	public MTwilioConf(Properties ctx, int CD_Twilio_Conf_ID, String trxName, String... virtualColumns) {
		super(ctx, CD_Twilio_Conf_ID, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MTwilioConf(Properties ctx, int CD_Twilio_Conf_ID, String trxName) {
		super(ctx, CD_Twilio_Conf_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MTwilioConf(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MTwilioConf(Properties ctx, String CD_Twilio_Conf_UU, String trxName, String... virtualColumns) {
		super(ctx, CD_Twilio_Conf_UU, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MTwilioConf(Properties ctx, String CD_Twilio_Conf_UU, String trxName) {
		super(ctx, CD_Twilio_Conf_UU, trxName);
		// TODO Auto-generated constructor stub
	}

}
