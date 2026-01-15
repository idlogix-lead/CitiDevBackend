package com.citidev.models;

import java.sql.ResultSet;
import java.util.Properties;

public class MCCAvenueConf extends X_CD_CcAvenue_Conf {

	public MCCAvenueConf(Properties ctx, int CD_CcAvenue_Conf_ID, String trxName, String... virtualColumns) {
		super(ctx, CD_CcAvenue_Conf_ID, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MCCAvenueConf(Properties ctx, int CD_CcAvenue_Conf_ID, String trxName) {
		super(ctx, CD_CcAvenue_Conf_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MCCAvenueConf(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MCCAvenueConf(Properties ctx, String CD_CcAvenue_Conf_UU, String trxName, String... virtualColumns) {
		super(ctx, CD_CcAvenue_Conf_UU, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MCCAvenueConf(Properties ctx, String CD_CcAvenue_Conf_UU, String trxName) {
		super(ctx, CD_CcAvenue_Conf_UU, trxName);
		// TODO Auto-generated constructor stub
	}

}
