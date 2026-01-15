package com.citidev.models;

import java.sql.ResultSet;
import java.util.Properties;

public class CDAttachmentEntry extends X_CD_Attachment_Entry{

	public CDAttachmentEntry(Properties ctx, int CD_Attachment_Entry_ID, String trxName, String... virtualColumns) {
		super(ctx, CD_Attachment_Entry_ID, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public CDAttachmentEntry(Properties ctx, int CD_Attachment_Entry_ID, String trxName) {
		super(ctx, CD_Attachment_Entry_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public CDAttachmentEntry(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public CDAttachmentEntry(Properties ctx, String CD_Attachment_Entry_UU, String trxName, String... virtualColumns) {
		super(ctx, CD_Attachment_Entry_UU, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public CDAttachmentEntry(Properties ctx, String CD_Attachment_Entry_UU, String trxName) {
		super(ctx, CD_Attachment_Entry_UU, trxName);
		// TODO Auto-generated constructor stub
	}

}
