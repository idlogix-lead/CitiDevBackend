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
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for CD_MFA
 *  @author iDempiere (generated)
 *  @version Release 11 - $Id$ */
@org.adempiere.base.Model(table="CD_MFA")
public class X_CD_MFA extends PO implements I_CD_MFA, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20251009L;

    /** Standard Constructor */
    public X_CD_MFA (Properties ctx, int CD_MFA_ID, String trxName)
    {
      super (ctx, CD_MFA_ID, trxName);
      /** if (CD_MFA_ID == 0)
        {
			setAD_User_ID (0);
			setCD_MFA_ID (0);
			setConsumed (false);
// N
			setIsVerified (false);
// N
			setvaliduntil (new Timestamp( System.currentTimeMillis() ));
        } */
    }

    /** Standard Constructor */
    public X_CD_MFA (Properties ctx, int CD_MFA_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, CD_MFA_ID, trxName, virtualColumns);
      /** if (CD_MFA_ID == 0)
        {
			setAD_User_ID (0);
			setCD_MFA_ID (0);
			setConsumed (false);
// N
			setIsVerified (false);
// N
			setvaliduntil (new Timestamp( System.currentTimeMillis() ));
        } */
    }

    /** Standard Constructor */
    public X_CD_MFA (Properties ctx, String CD_MFA_UU, String trxName)
    {
      super (ctx, CD_MFA_UU, trxName);
      /** if (CD_MFA_UU == null)
        {
			setAD_User_ID (0);
			setCD_MFA_ID (0);
			setConsumed (false);
// N
			setIsVerified (false);
// N
			setvaliduntil (new Timestamp( System.currentTimeMillis() ));
        } */
    }

    /** Standard Constructor */
    public X_CD_MFA (Properties ctx, String CD_MFA_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, CD_MFA_UU, trxName, virtualColumns);
      /** if (CD_MFA_UU == null)
        {
			setAD_User_ID (0);
			setCD_MFA_ID (0);
			setConsumed (false);
// N
			setIsVerified (false);
// N
			setvaliduntil (new Timestamp( System.currentTimeMillis() ));
        } */
    }

    /** Load Constructor */
    public X_CD_MFA (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_CD_MFA[")
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

	/** Set MFA OTP.
		@param CD_MFA_ID MFA OTP
	*/
	public void setCD_MFA_ID (int CD_MFA_ID)
	{
		if (CD_MFA_ID < 1)
			set_ValueNoCheck (COLUMNNAME_CD_MFA_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_CD_MFA_ID, Integer.valueOf(CD_MFA_ID));
	}

	/** Get MFA OTP.
		@return MFA OTP	  */
	public int getCD_MFA_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_CD_MFA_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set CD_MFA_UU.
		@param CD_MFA_UU CD_MFA_UU
	*/
	public void setCD_MFA_UU (String CD_MFA_UU)
	{
		set_ValueNoCheck (COLUMNNAME_CD_MFA_UU, CD_MFA_UU);
	}

	/** Get CD_MFA_UU.
		@return CD_MFA_UU	  */
	public String getCD_MFA_UU()
	{
		return (String)get_Value(COLUMNNAME_CD_MFA_UU);
	}

	/** Set Consumed.
		@param Consumed Consumed
	*/
	public void setConsumed (boolean Consumed)
	{
		set_Value (COLUMNNAME_Consumed, Boolean.valueOf(Consumed));
	}

	/** Get Consumed.
		@return Consumed	  */
	public boolean isConsumed()
	{
		Object oo = get_Value(COLUMNNAME_Consumed);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set EMail Address.
		@param EMail Electronic Mail Address
	*/
	public void setEMail (String EMail)
	{
		set_Value (COLUMNNAME_EMail, EMail);
	}

	/** Get EMail Address.
		@return Electronic Mail Address
	  */
	public String getEMail()
	{
		return (String)get_Value(COLUMNNAME_EMail);
	}

	/** Set Verified.
		@param IsVerified The BOM configuration has been verified
	*/
	public void setIsVerified (boolean IsVerified)
	{
		set_ValueNoCheck (COLUMNNAME_IsVerified, Boolean.valueOf(IsVerified));
	}

	/** Get Verified.
		@return The BOM configuration has been verified
	  */
	public boolean isVerified()
	{
		Object oo = get_Value(COLUMNNAME_IsVerified);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set attemptcount.
		@param attemptcount attemptcount
	*/
	public void setattemptcount (int attemptcount)
	{
		set_Value (COLUMNNAME_attemptcount, Integer.valueOf(attemptcount));
	}

	/** Get attemptcount.
		@return attemptcount	  */
	public int getattemptcount()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_attemptcount);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set otp.
		@param otp otp
	*/
	public void setotp (String otp)
	{
		set_Value (COLUMNNAME_otp, otp);
	}

	/** Get otp.
		@return otp	  */
	public String getotp()
	{
		return (String)get_Value(COLUMNNAME_otp);
	}

	/** Set validuntil.
		@param validuntil validuntil
	*/
	public void setvaliduntil (Timestamp validuntil)
	{
		set_Value (COLUMNNAME_validuntil, validuntil);
	}

	/** Get validuntil.
		@return validuntil	  */
	public Timestamp getvaliduntil()
	{
		return (Timestamp)get_Value(COLUMNNAME_validuntil);
	}
}