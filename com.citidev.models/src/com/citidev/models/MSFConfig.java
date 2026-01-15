package com.citidev.models;

import java.sql.ResultSet;
import java.util.Properties;

public class MSFConfig extends X_SF_Config{

	public MSFConfig(Properties ctx, int SF_Config_ID, String trxName, String... virtualColumns) {
		super(ctx, SF_Config_ID, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MSFConfig(Properties ctx, int SF_Config_ID, String trxName) {
		super(ctx, SF_Config_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MSFConfig(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MSFConfig(Properties ctx, String SF_Config_UU, String trxName, String... virtualColumns) {
		super(ctx, SF_Config_UU, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MSFConfig(Properties ctx, String SF_Config_UU, String trxName) {
		super(ctx, SF_Config_UU, trxName);
		// TODO Auto-generated constructor stub
	}

}
