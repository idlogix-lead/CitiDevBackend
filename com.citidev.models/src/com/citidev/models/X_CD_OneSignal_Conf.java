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

/** Generated Model for CD_OneSignal_Conf
 *  @author iDempiere (generated)
 *  @version Release 11 - $Id$ */
@org.adempiere.base.Model(table="CD_OneSignal_Conf")
public class X_CD_OneSignal_Conf extends PO implements I_CD_OneSignal_Conf, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20260113L;

    /** Standard Constructor */
    public X_CD_OneSignal_Conf (Properties ctx, int CD_OneSignal_Conf_ID, String trxName)
    {
      super (ctx, CD_OneSignal_Conf_ID, trxName);
      /** if (CD_OneSignal_Conf_ID == 0)
        {
			setCD_OneSignal_Conf_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_CD_OneSignal_Conf (Properties ctx, int CD_OneSignal_Conf_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, CD_OneSignal_Conf_ID, trxName, virtualColumns);
      /** if (CD_OneSignal_Conf_ID == 0)
        {
			setCD_OneSignal_Conf_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_CD_OneSignal_Conf (Properties ctx, String CD_OneSignal_Conf_UU, String trxName)
    {
      super (ctx, CD_OneSignal_Conf_UU, trxName);
      /** if (CD_OneSignal_Conf_UU == null)
        {
			setCD_OneSignal_Conf_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_CD_OneSignal_Conf (Properties ctx, String CD_OneSignal_Conf_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, CD_OneSignal_Conf_UU, trxName, virtualColumns);
      /** if (CD_OneSignal_Conf_UU == null)
        {
			setCD_OneSignal_Conf_ID (0);
        } */
    }

    /** Load Constructor */
    public X_CD_OneSignal_Conf (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_CD_OneSignal_Conf[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set CD_OneSignal_Conf.
		@param CD_OneSignal_Conf_ID CD_OneSignal_Conf
	*/
	public void setCD_OneSignal_Conf_ID (int CD_OneSignal_Conf_ID)
	{
		if (CD_OneSignal_Conf_ID < 1)
			set_ValueNoCheck (COLUMNNAME_CD_OneSignal_Conf_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_CD_OneSignal_Conf_ID, Integer.valueOf(CD_OneSignal_Conf_ID));
	}

	/** Get CD_OneSignal_Conf.
		@return CD_OneSignal_Conf	  */
	public int getCD_OneSignal_Conf_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_CD_OneSignal_Conf_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set CD_OneSignal_Conf_UU.
		@param CD_OneSignal_Conf_UU CD_OneSignal_Conf_UU
	*/
	public void setCD_OneSignal_Conf_UU (String CD_OneSignal_Conf_UU)
	{
		set_ValueNoCheck (COLUMNNAME_CD_OneSignal_Conf_UU, CD_OneSignal_Conf_UU);
	}

	/** Get CD_OneSignal_Conf_UU.
		@return CD_OneSignal_Conf_UU	  */
	public String getCD_OneSignal_Conf_UU()
	{
		return (String)get_Value(COLUMNNAME_CD_OneSignal_Conf_UU);
	}

	/** Set onesignal_appid.
		@param onesignal_appid onesignal_appid
	*/
	public void setonesignal_appid (String onesignal_appid)
	{
		set_Value (COLUMNNAME_onesignal_appid, onesignal_appid);
	}

	/** Get onesignal_appid.
		@return onesignal_appid	  */
	public String getonesignal_appid()
	{
		return (String)get_Value(COLUMNNAME_onesignal_appid);
	}

	/** Set onesignal_email_api_key.
		@param onesignal_email_api_key onesignal_email_api_key
	*/
	public void setonesignal_email_api_key (String onesignal_email_api_key)
	{
		set_Value (COLUMNNAME_onesignal_email_api_key, onesignal_email_api_key);
	}

	/** Get onesignal_email_api_key.
		@return onesignal_email_api_key	  */
	public String getonesignal_email_api_key()
	{
		return (String)get_Value(COLUMNNAME_onesignal_email_api_key);
	}
}