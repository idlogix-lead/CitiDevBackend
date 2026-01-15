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
/** Generated Model - DO NOT CHANGE */
package com.citidev.models;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for CD_Notifications_Prefs
 *  @author iDempiere (generated)
 *  @version Release 11 - $Id$ */
@org.adempiere.base.Model(table="CD_Notifications_Prefs")
public class X_CD_Notifications_Prefs extends PO implements I_CD_Notifications_Prefs, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20251126L;

    /** Standard Constructor */
    public X_CD_Notifications_Prefs (Properties ctx, int CD_Notifications_Prefs_ID, String trxName)
    {
      super (ctx, CD_Notifications_Prefs_ID, trxName);
      /** if (CD_Notifications_Prefs_ID == 0)
        {
			setAD_User_ID (0);
			setCD_Notifications_Prefs_ID (0);
			setconstruction_email (false);
// N
			setconstruction_push (false);
// N
			setconstruction_whatsapp (false);
// N
			setkyc_email (false);
// N
			setkyc_push (false);
// N
			setkyc_whatsapp (false);
// N
			setpayment_daily_until_paid (false);
// N
			setpayment_email (false);
// N
			setpayment_on_billing_date (false);
// N
			setpayment_one_day_after_due (false);
// N
			setpayment_one_day_before_due (false);
// N
			setpayment_push (false);
// N
			setpayment_whatsapp (false);
// N
        } */
    }

    /** Standard Constructor */
    public X_CD_Notifications_Prefs (Properties ctx, int CD_Notifications_Prefs_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, CD_Notifications_Prefs_ID, trxName, virtualColumns);
      /** if (CD_Notifications_Prefs_ID == 0)
        {
			setAD_User_ID (0);
			setCD_Notifications_Prefs_ID (0);
			setconstruction_email (false);
// N
			setconstruction_push (false);
// N
			setconstruction_whatsapp (false);
// N
			setkyc_email (false);
// N
			setkyc_push (false);
// N
			setkyc_whatsapp (false);
// N
			setpayment_daily_until_paid (false);
// N
			setpayment_email (false);
// N
			setpayment_on_billing_date (false);
// N
			setpayment_one_day_after_due (false);
// N
			setpayment_one_day_before_due (false);
// N
			setpayment_push (false);
// N
			setpayment_whatsapp (false);
// N
        } */
    }

    /** Standard Constructor */
    public X_CD_Notifications_Prefs (Properties ctx, String CD_Notifications_Prefs_UU, String trxName)
    {
      super (ctx, CD_Notifications_Prefs_UU, trxName);
      /** if (CD_Notifications_Prefs_UU == null)
        {
			setAD_User_ID (0);
			setCD_Notifications_Prefs_ID (0);
			setconstruction_email (false);
// N
			setconstruction_push (false);
// N
			setconstruction_whatsapp (false);
// N
			setkyc_email (false);
// N
			setkyc_push (false);
// N
			setkyc_whatsapp (false);
// N
			setpayment_daily_until_paid (false);
// N
			setpayment_email (false);
// N
			setpayment_on_billing_date (false);
// N
			setpayment_one_day_after_due (false);
// N
			setpayment_one_day_before_due (false);
// N
			setpayment_push (false);
// N
			setpayment_whatsapp (false);
// N
        } */
    }

    /** Standard Constructor */
    public X_CD_Notifications_Prefs (Properties ctx, String CD_Notifications_Prefs_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, CD_Notifications_Prefs_UU, trxName, virtualColumns);
      /** if (CD_Notifications_Prefs_UU == null)
        {
			setAD_User_ID (0);
			setCD_Notifications_Prefs_ID (0);
			setconstruction_email (false);
// N
			setconstruction_push (false);
// N
			setconstruction_whatsapp (false);
// N
			setkyc_email (false);
// N
			setkyc_push (false);
// N
			setkyc_whatsapp (false);
// N
			setpayment_daily_until_paid (false);
// N
			setpayment_email (false);
// N
			setpayment_on_billing_date (false);
// N
			setpayment_one_day_after_due (false);
// N
			setpayment_one_day_before_due (false);
// N
			setpayment_push (false);
// N
			setpayment_whatsapp (false);
// N
        } */
    }

    /** Load Constructor */
    public X_CD_Notifications_Prefs (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuilder sb = new StringBuilder ("X_CD_Notifications_Prefs[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_User getAD_User() throws RuntimeException
	{
		return (org.compiere.model.I_AD_User)MTable.get(getCtx(), org.compiere.model.I_AD_User.Table_ID)
			.getPO(getAD_User_ID(), get_TrxName());
	}

	/** Set User/Contact.
		@param AD_User_ID User within the system - Internal or Business Partner Contact
	*/
	public void setAD_User_ID (int AD_User_ID)
	{
		if (AD_User_ID < 1)
			set_ValueNoCheck (COLUMNNAME_AD_User_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_AD_User_ID, Integer.valueOf(AD_User_ID));
	}

	/** Get User/Contact.
		@return User within the system - Internal or Business Partner Contact
	  */
	public int getAD_User_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_User_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set User Notifications Preferences.
		@param CD_Notifications_Prefs_ID User Notifications Preferences
	*/
	public void setCD_Notifications_Prefs_ID (int CD_Notifications_Prefs_ID)
	{
		if (CD_Notifications_Prefs_ID < 1)
			set_ValueNoCheck (COLUMNNAME_CD_Notifications_Prefs_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_CD_Notifications_Prefs_ID, Integer.valueOf(CD_Notifications_Prefs_ID));
	}

	/** Get User Notifications Preferences.
		@return User Notifications Preferences	  */
	public int getCD_Notifications_Prefs_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_CD_Notifications_Prefs_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set CD_Notifications_Prefs_UU.
		@param CD_Notifications_Prefs_UU CD_Notifications_Prefs_UU
	*/
	public void setCD_Notifications_Prefs_UU (String CD_Notifications_Prefs_UU)
	{
		set_ValueNoCheck (COLUMNNAME_CD_Notifications_Prefs_UU, CD_Notifications_Prefs_UU);
	}

	/** Get CD_Notifications_Prefs_UU.
		@return CD_Notifications_Prefs_UU	  */
	public String getCD_Notifications_Prefs_UU()
	{
		return (String)get_Value(COLUMNNAME_CD_Notifications_Prefs_UU);
	}

	/** Set construction_email.
		@param construction_email construction_email
	*/
	public void setconstruction_email (boolean construction_email)
	{
		set_Value (COLUMNNAME_construction_email, Boolean.valueOf(construction_email));
	}

	/** Get construction_email.
		@return construction_email	  */
	public boolean isconstruction_email()
	{
		Object oo = get_Value(COLUMNNAME_construction_email);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set construction_push.
		@param construction_push construction_push
	*/
	public void setconstruction_push (boolean construction_push)
	{
		set_Value (COLUMNNAME_construction_push, Boolean.valueOf(construction_push));
	}

	/** Get construction_push.
		@return construction_push	  */
	public boolean isconstruction_push()
	{
		Object oo = get_Value(COLUMNNAME_construction_push);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set construction_whatsapp.
		@param construction_whatsapp construction_whatsapp
	*/
	public void setconstruction_whatsapp (boolean construction_whatsapp)
	{
		set_Value (COLUMNNAME_construction_whatsapp, Boolean.valueOf(construction_whatsapp));
	}

	/** Get construction_whatsapp.
		@return construction_whatsapp	  */
	public boolean isconstruction_whatsapp()
	{
		Object oo = get_Value(COLUMNNAME_construction_whatsapp);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set kyc_email.
		@param kyc_email kyc_email
	*/
	public void setkyc_email (boolean kyc_email)
	{
		set_Value (COLUMNNAME_kyc_email, Boolean.valueOf(kyc_email));
	}

	/** Get kyc_email.
		@return kyc_email	  */
	public boolean iskyc_email()
	{
		Object oo = get_Value(COLUMNNAME_kyc_email);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set kyc_push.
		@param kyc_push kyc_push
	*/
	public void setkyc_push (boolean kyc_push)
	{
		set_Value (COLUMNNAME_kyc_push, Boolean.valueOf(kyc_push));
	}

	/** Get kyc_push.
		@return kyc_push	  */
	public boolean iskyc_push()
	{
		Object oo = get_Value(COLUMNNAME_kyc_push);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set kyc_whatsapp.
		@param kyc_whatsapp kyc_whatsapp
	*/
	public void setkyc_whatsapp (boolean kyc_whatsapp)
	{
		set_Value (COLUMNNAME_kyc_whatsapp, Boolean.valueOf(kyc_whatsapp));
	}

	/** Get kyc_whatsapp.
		@return kyc_whatsapp	  */
	public boolean iskyc_whatsapp()
	{
		Object oo = get_Value(COLUMNNAME_kyc_whatsapp);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set payment_daily_until_paid.
		@param payment_daily_until_paid payment_daily_until_paid
	*/
	public void setpayment_daily_until_paid (boolean payment_daily_until_paid)
	{
		set_Value (COLUMNNAME_payment_daily_until_paid, Boolean.valueOf(payment_daily_until_paid));
	}

	/** Get payment_daily_until_paid.
		@return payment_daily_until_paid	  */
	public boolean ispayment_daily_until_paid()
	{
		Object oo = get_Value(COLUMNNAME_payment_daily_until_paid);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set payment_email.
		@param payment_email payment_email
	*/
	public void setpayment_email (boolean payment_email)
	{
		set_Value (COLUMNNAME_payment_email, Boolean.valueOf(payment_email));
	}

	/** Get payment_email.
		@return payment_email	  */
	public boolean ispayment_email()
	{
		Object oo = get_Value(COLUMNNAME_payment_email);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set payment_on_billing_date.
		@param payment_on_billing_date payment_on_billing_date
	*/
	public void setpayment_on_billing_date (boolean payment_on_billing_date)
	{
		set_Value (COLUMNNAME_payment_on_billing_date, Boolean.valueOf(payment_on_billing_date));
	}

	/** Get payment_on_billing_date.
		@return payment_on_billing_date	  */
	public boolean ispayment_on_billing_date()
	{
		Object oo = get_Value(COLUMNNAME_payment_on_billing_date);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set payment_one_day_after_due.
		@param payment_one_day_after_due payment_one_day_after_due
	*/
	public void setpayment_one_day_after_due (boolean payment_one_day_after_due)
	{
		set_Value (COLUMNNAME_payment_one_day_after_due, Boolean.valueOf(payment_one_day_after_due));
	}

	/** Get payment_one_day_after_due.
		@return payment_one_day_after_due	  */
	public boolean ispayment_one_day_after_due()
	{
		Object oo = get_Value(COLUMNNAME_payment_one_day_after_due);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set payment_one_day_before_due.
		@param payment_one_day_before_due payment_one_day_before_due
	*/
	public void setpayment_one_day_before_due (boolean payment_one_day_before_due)
	{
		set_Value (COLUMNNAME_payment_one_day_before_due, Boolean.valueOf(payment_one_day_before_due));
	}

	/** Get payment_one_day_before_due.
		@return payment_one_day_before_due	  */
	public boolean ispayment_one_day_before_due()
	{
		Object oo = get_Value(COLUMNNAME_payment_one_day_before_due);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set payment_push.
		@param payment_push payment_push
	*/
	public void setpayment_push (boolean payment_push)
	{
		set_Value (COLUMNNAME_payment_push, Boolean.valueOf(payment_push));
	}

	/** Get payment_push.
		@return payment_push	  */
	public boolean ispayment_push()
	{
		Object oo = get_Value(COLUMNNAME_payment_push);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set payment_whatsapp.
		@param payment_whatsapp payment_whatsapp
	*/
	public void setpayment_whatsapp (boolean payment_whatsapp)
	{
		set_Value (COLUMNNAME_payment_whatsapp, Boolean.valueOf(payment_whatsapp));
	}

	/** Get payment_whatsapp.
		@return payment_whatsapp	  */
	public boolean ispayment_whatsapp()
	{
		Object oo = get_Value(COLUMNNAME_payment_whatsapp);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}
}