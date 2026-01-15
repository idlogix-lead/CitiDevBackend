package com.citidev.models;

import java.sql.ResultSet;
import java.util.Properties;

public class MCCAvenuPaymentResponse extends X_CD_CCPayment_Response{

	public MCCAvenuPaymentResponse(Properties ctx, int CD_CCPayment_Response_ID, String trxName,
			String... virtualColumns) {
		super(ctx, CD_CCPayment_Response_ID, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MCCAvenuPaymentResponse(Properties ctx, int CD_CCPayment_Response_ID, String trxName) {
		super(ctx, CD_CCPayment_Response_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MCCAvenuPaymentResponse(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MCCAvenuPaymentResponse(Properties ctx, String CD_CCPayment_Response_UU, String trxName,
			String... virtualColumns) {
		super(ctx, CD_CCPayment_Response_UU, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MCCAvenuPaymentResponse(Properties ctx, String CD_CCPayment_Response_UU, String trxName) {
		super(ctx, CD_CCPayment_Response_UU, trxName);
		// TODO Auto-generated constructor stub
	}

}
