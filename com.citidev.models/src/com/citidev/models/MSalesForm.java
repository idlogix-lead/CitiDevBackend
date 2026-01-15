package com.citidev.models;

import java.sql.ResultSet;
import java.util.Properties;

public class MSalesForm extends X_SalesForm{

	public MSalesForm(Properties ctx, int SalesForm_ID, String trxName, String... virtualColumns) {
		super(ctx, SalesForm_ID, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MSalesForm(Properties ctx, int SalesForm_ID, String trxName) {
		super(ctx, SalesForm_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MSalesForm(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MSalesForm(Properties ctx, String SalesForm_UU, String trxName, String... virtualColumns) {
		super(ctx, SalesForm_UU, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MSalesForm(Properties ctx, String SalesForm_UU, String trxName) {
		super(ctx, SalesForm_UU, trxName);
		// TODO Auto-generated constructor stub
	}

}
