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

/** Generated Model for CD_Twilio_Conf
 *  @author iDempiere (generated)
 *  @version Release 11 - $Id$ */
@org.adempiere.base.Model(table="CD_Twilio_Conf")
public class X_CD_Twilio_Conf extends PO implements I_CD_Twilio_Conf, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20251203L;

    /** Standard Constructor */
    public X_CD_Twilio_Conf (Properties ctx, int CD_Twilio_Conf_ID, String trxName)
    {
      super (ctx, CD_Twilio_Conf_ID, trxName);
      /** if (CD_Twilio_Conf_ID == 0)
        {
			setCD_Twilio_Conf_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_CD_Twilio_Conf (Properties ctx, int CD_Twilio_Conf_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, CD_Twilio_Conf_ID, trxName, virtualColumns);
      /** if (CD_Twilio_Conf_ID == 0)
        {
			setCD_Twilio_Conf_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_CD_Twilio_Conf (Properties ctx, String CD_Twilio_Conf_UU, String trxName)
    {
      super (ctx, CD_Twilio_Conf_UU, trxName);
      /** if (CD_Twilio_Conf_UU == null)
        {
			setCD_Twilio_Conf_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_CD_Twilio_Conf (Properties ctx, String CD_Twilio_Conf_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, CD_Twilio_Conf_UU, trxName, virtualColumns);
      /** if (CD_Twilio_Conf_UU == null)
        {
			setCD_Twilio_Conf_ID (0);
        } */
    }

    /** Load Constructor */
    public X_CD_Twilio_Conf (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_CD_Twilio_Conf[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set CD_Twilio_Conf.
		@param CD_Twilio_Conf_ID CD_Twilio_Conf
	*/
	public void setCD_Twilio_Conf_ID (int CD_Twilio_Conf_ID)
	{
		if (CD_Twilio_Conf_ID < 1)
			set_ValueNoCheck (COLUMNNAME_CD_Twilio_Conf_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_CD_Twilio_Conf_ID, Integer.valueOf(CD_Twilio_Conf_ID));
	}

	/** Get CD_Twilio_Conf.
		@return CD_Twilio_Conf	  */
	public int getCD_Twilio_Conf_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_CD_Twilio_Conf_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set CD_Twilio_Conf_UU.
		@param CD_Twilio_Conf_UU CD_Twilio_Conf_UU
	*/
	public void setCD_Twilio_Conf_UU (String CD_Twilio_Conf_UU)
	{
		set_ValueNoCheck (COLUMNNAME_CD_Twilio_Conf_UU, CD_Twilio_Conf_UU);
	}

	/** Get CD_Twilio_Conf_UU.
		@return CD_Twilio_Conf_UU	  */
	public String getCD_Twilio_Conf_UU()
	{
		return (String)get_Value(COLUMNNAME_CD_Twilio_Conf_UU);
	}

	/** Set twilio_account_sid.
		@param twilio_account_sid twilio_account_sid
	*/
	public void settwilio_account_sid (String twilio_account_sid)
	{
		set_Value (COLUMNNAME_twilio_account_sid, twilio_account_sid);
	}

	/** Get twilio_account_sid.
		@return twilio_account_sid	  */
	public String gettwilio_account_sid()
	{
		return (String)get_Value(COLUMNNAME_twilio_account_sid);
	}

	/** Set twilio_auth_token.
		@param twilio_auth_token twilio_auth_token
	*/
	public void settwilio_auth_token (String twilio_auth_token)
	{
		set_Value (COLUMNNAME_twilio_auth_token, twilio_auth_token);
	}

	/** Get twilio_auth_token.
		@return twilio_auth_token	  */
	public String gettwilio_auth_token()
	{
		return (String)get_Value(COLUMNNAME_twilio_auth_token);
	}

	/** Set twilio_whatsapp_number.
		@param twilio_whatsapp_number twilio_whatsapp_number
	*/
	public void settwilio_whatsapp_number (String twilio_whatsapp_number)
	{
		set_Value (COLUMNNAME_twilio_whatsapp_number, twilio_whatsapp_number);
	}

	/** Get twilio_whatsapp_number.
		@return twilio_whatsapp_number	  */
	public String gettwilio_whatsapp_number()
	{
		return (String)get_Value(COLUMNNAME_twilio_whatsapp_number);
	}
}