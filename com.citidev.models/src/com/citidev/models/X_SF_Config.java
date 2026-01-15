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

/** Generated Model for SF_Config
 *  @author iDempiere (generated)
 *  @version Release 11 - $Id$ */
@org.adempiere.base.Model(table="SF_Config")
public class X_SF_Config extends PO implements I_SF_Config, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20251003L;

    /** Standard Constructor */
    public X_SF_Config (Properties ctx, int SF_Config_ID, String trxName)
    {
      super (ctx, SF_Config_ID, trxName);
      /** if (SF_Config_ID == 0)
        {
			setSF_Config_ID (0);
			setclientid (null);
			setinstanceurl (null);
        } */
    }

    /** Standard Constructor */
    public X_SF_Config (Properties ctx, int SF_Config_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, SF_Config_ID, trxName, virtualColumns);
      /** if (SF_Config_ID == 0)
        {
			setSF_Config_ID (0);
			setclientid (null);
			setinstanceurl (null);
        } */
    }

    /** Standard Constructor */
    public X_SF_Config (Properties ctx, String SF_Config_UU, String trxName)
    {
      super (ctx, SF_Config_UU, trxName);
      /** if (SF_Config_UU == null)
        {
			setSF_Config_ID (0);
			setclientid (null);
			setinstanceurl (null);
        } */
    }

    /** Standard Constructor */
    public X_SF_Config (Properties ctx, String SF_Config_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, SF_Config_UU, trxName, virtualColumns);
      /** if (SF_Config_UU == null)
        {
			setSF_Config_ID (0);
			setclientid (null);
			setinstanceurl (null);
        } */
    }

    /** Load Constructor */
    public X_SF_Config (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_SF_Config[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	/** Set Description.
		@param Description Optional short description of the record
	*/
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription()
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set Name.
		@param Name Alphanumeric identifier of the entity
	*/
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName()
	{
		return (String)get_Value(COLUMNNAME_Name);
	}

	/** Set Password.
		@param Password Password of any length (case sensitive)
	*/
	public void setPassword (String Password)
	{
		set_Value (COLUMNNAME_Password, Password);
	}

	/** Get Password.
		@return Password of any length (case sensitive)
	  */
	public String getPassword()
	{
		return (String)get_Value(COLUMNNAME_Password);
	}

	/** Set SalesForce Configuration.
		@param SF_Config_ID SalesForce Configuration
	*/
	public void setSF_Config_ID (int SF_Config_ID)
	{
		if (SF_Config_ID < 1)
			set_ValueNoCheck (COLUMNNAME_SF_Config_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_SF_Config_ID, Integer.valueOf(SF_Config_ID));
	}

	/** Get SalesForce Configuration.
		@return SalesForce Configuration	  */
	public int getSF_Config_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_SF_Config_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set SF_Config_UU.
		@param SF_Config_UU SF_Config_UU
	*/
	public void setSF_Config_UU (String SF_Config_UU)
	{
		set_ValueNoCheck (COLUMNNAME_SF_Config_UU, SF_Config_UU);
	}

	/** Get SF_Config_UU.
		@return SF_Config_UU	  */
	public String getSF_Config_UU()
	{
		return (String)get_Value(COLUMNNAME_SF_Config_UU);
	}

	/** Set User Name.
		@param UserName User Name
	*/
	public void setUserName (String UserName)
	{
		set_Value (COLUMNNAME_UserName, UserName);
	}

	/** Get User Name.
		@return User Name	  */
	public String getUserName()
	{
		return (String)get_Value(COLUMNNAME_UserName);
	}

	/** Set Search Key.
		@param Value Search key for the record in the format required - must be unique
	*/
	public void setValue (String Value)
	{
		set_Value (COLUMNNAME_Value, Value);
	}

	/** Get Search Key.
		@return Search key for the record in the format required - must be unique
	  */
	public String getValue()
	{
		return (String)get_Value(COLUMNNAME_Value);
	}

	/** Set clientid.
		@param clientid clientid
	*/
	public void setclientid (String clientid)
	{
		set_Value (COLUMNNAME_clientid, clientid);
	}

	/** Get clientid.
		@return clientid	  */
	public String getclientid()
	{
		return (String)get_Value(COLUMNNAME_clientid);
	}

	/** Set clientsecret.
		@param clientsecret clientsecret
	*/
	public void setclientsecret (String clientsecret)
	{
		set_Value (COLUMNNAME_clientsecret, clientsecret);
	}

	/** Get clientsecret.
		@return clientsecret	  */
	public String getclientsecret()
	{
		return (String)get_Value(COLUMNNAME_clientsecret);
	}

	/** Set instanceurl.
		@param instanceurl instanceurl
	*/
	public void setinstanceurl (String instanceurl)
	{
		set_Value (COLUMNNAME_instanceurl, instanceurl);
	}

	/** Get instanceurl.
		@return instanceurl	  */
	public String getinstanceurl()
	{
		return (String)get_Value(COLUMNNAME_instanceurl);
	}
}