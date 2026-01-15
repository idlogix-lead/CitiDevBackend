/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
package com.citidev.models;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for CD_Notifications_Prefs
 *  @author iDempiere (generated) 
 *  @version Release 11
 */
@SuppressWarnings("all")
public interface I_CD_Notifications_Prefs 
{

    /** TableName=CD_Notifications_Prefs */
    public static final String Table_Name = "CD_Notifications_Prefs";

    /** AD_Table_ID=1000012 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Tenant.
	  * Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within tenant
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within tenant
	  */
	public int getAD_Org_ID();

    /** Column name AD_User_ID */
    public static final String COLUMNNAME_AD_User_ID = "AD_User_ID";

	/** Set User/Contact.
	  * User within the system - Internal or Business Partner Contact
	  */
	public void setAD_User_ID (int AD_User_ID);

	/** Get User/Contact.
	  * User within the system - Internal or Business Partner Contact
	  */
	public int getAD_User_ID();

	public org.compiere.model.I_AD_User getAD_User() throws RuntimeException;

    /** Column name CD_Notifications_Prefs_ID */
    public static final String COLUMNNAME_CD_Notifications_Prefs_ID = "CD_Notifications_Prefs_ID";

	/** Set User Notifications Preferences	  */
	public void setCD_Notifications_Prefs_ID (int CD_Notifications_Prefs_ID);

	/** Get User Notifications Preferences	  */
	public int getCD_Notifications_Prefs_ID();

    /** Column name CD_Notifications_Prefs_UU */
    public static final String COLUMNNAME_CD_Notifications_Prefs_UU = "CD_Notifications_Prefs_UU";

	/** Set CD_Notifications_Prefs_UU	  */
	public void setCD_Notifications_Prefs_UU (String CD_Notifications_Prefs_UU);

	/** Get CD_Notifications_Prefs_UU	  */
	public String getCD_Notifications_Prefs_UU();

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();

    /** Column name construction_email */
    public static final String COLUMNNAME_construction_email = "construction_email";

	/** Set construction_email	  */
	public void setconstruction_email (boolean construction_email);

	/** Get construction_email	  */
	public boolean isconstruction_email();

    /** Column name construction_push */
    public static final String COLUMNNAME_construction_push = "construction_push";

	/** Set construction_push	  */
	public void setconstruction_push (boolean construction_push);

	/** Get construction_push	  */
	public boolean isconstruction_push();

    /** Column name construction_whatsapp */
    public static final String COLUMNNAME_construction_whatsapp = "construction_whatsapp";

	/** Set construction_whatsapp	  */
	public void setconstruction_whatsapp (boolean construction_whatsapp);

	/** Get construction_whatsapp	  */
	public boolean isconstruction_whatsapp();

    /** Column name kyc_email */
    public static final String COLUMNNAME_kyc_email = "kyc_email";

	/** Set kyc_email	  */
	public void setkyc_email (boolean kyc_email);

	/** Get kyc_email	  */
	public boolean iskyc_email();

    /** Column name kyc_push */
    public static final String COLUMNNAME_kyc_push = "kyc_push";

	/** Set kyc_push	  */
	public void setkyc_push (boolean kyc_push);

	/** Get kyc_push	  */
	public boolean iskyc_push();

    /** Column name kyc_whatsapp */
    public static final String COLUMNNAME_kyc_whatsapp = "kyc_whatsapp";

	/** Set kyc_whatsapp	  */
	public void setkyc_whatsapp (boolean kyc_whatsapp);

	/** Get kyc_whatsapp	  */
	public boolean iskyc_whatsapp();

    /** Column name payment_daily_until_paid */
    public static final String COLUMNNAME_payment_daily_until_paid = "payment_daily_until_paid";

	/** Set payment_daily_until_paid	  */
	public void setpayment_daily_until_paid (boolean payment_daily_until_paid);

	/** Get payment_daily_until_paid	  */
	public boolean ispayment_daily_until_paid();

    /** Column name payment_email */
    public static final String COLUMNNAME_payment_email = "payment_email";

	/** Set payment_email	  */
	public void setpayment_email (boolean payment_email);

	/** Get payment_email	  */
	public boolean ispayment_email();

    /** Column name payment_on_billing_date */
    public static final String COLUMNNAME_payment_on_billing_date = "payment_on_billing_date";

	/** Set payment_on_billing_date	  */
	public void setpayment_on_billing_date (boolean payment_on_billing_date);

	/** Get payment_on_billing_date	  */
	public boolean ispayment_on_billing_date();

    /** Column name payment_one_day_after_due */
    public static final String COLUMNNAME_payment_one_day_after_due = "payment_one_day_after_due";

	/** Set payment_one_day_after_due	  */
	public void setpayment_one_day_after_due (boolean payment_one_day_after_due);

	/** Get payment_one_day_after_due	  */
	public boolean ispayment_one_day_after_due();

    /** Column name payment_one_day_before_due */
    public static final String COLUMNNAME_payment_one_day_before_due = "payment_one_day_before_due";

	/** Set payment_one_day_before_due	  */
	public void setpayment_one_day_before_due (boolean payment_one_day_before_due);

	/** Get payment_one_day_before_due	  */
	public boolean ispayment_one_day_before_due();

    /** Column name payment_push */
    public static final String COLUMNNAME_payment_push = "payment_push";

	/** Set payment_push	  */
	public void setpayment_push (boolean payment_push);

	/** Get payment_push	  */
	public boolean ispayment_push();

    /** Column name payment_whatsapp */
    public static final String COLUMNNAME_payment_whatsapp = "payment_whatsapp";

	/** Set payment_whatsapp	  */
	public void setpayment_whatsapp (boolean payment_whatsapp);

	/** Get payment_whatsapp	  */
	public boolean ispayment_whatsapp();
}
