package com.citidev.models;

import java.sql.ResultSet;
import java.util.Properties;

public class MCDMFA extends X_CD_MFA{

	public MCDMFA(Properties ctx, int CD_MFA_ID, String trxName, String... virtualColumns) {
		super(ctx, CD_MFA_ID, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MCDMFA(Properties ctx, int CD_MFA_ID, String trxName) {
		super(ctx, CD_MFA_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MCDMFA(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MCDMFA(Properties ctx, String CD_MFA_UU, String trxName, String... virtualColumns) {
		super(ctx, CD_MFA_UU, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MCDMFA(Properties ctx, String CD_MFA_UU, String trxName) {
		super(ctx, CD_MFA_UU, trxName);
		// TODO Auto-generated constructor stub
	}

}
