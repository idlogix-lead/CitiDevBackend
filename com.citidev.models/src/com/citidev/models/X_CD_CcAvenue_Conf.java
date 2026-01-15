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

/** Generated Model for CD_CcAvenue_Conf
 *  @author iDempiere (generated)
 *  @version Release 11 - $Id$ */
@org.adempiere.base.Model(table="CD_CcAvenue_Conf")
public class X_CD_CcAvenue_Conf extends PO implements I_CD_CcAvenue_Conf, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20251015L;

    /** Standard Constructor */
    public X_CD_CcAvenue_Conf (Properties ctx, int CD_CcAvenue_Conf_ID, String trxName)
    {
      super (ctx, CD_CcAvenue_Conf_ID, trxName);
      /** if (CD_CcAvenue_Conf_ID == 0)
        {
			setCD_CcAvenue_Conf_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_CD_CcAvenue_Conf (Properties ctx, int CD_CcAvenue_Conf_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, CD_CcAvenue_Conf_ID, trxName, virtualColumns);
      /** if (CD_CcAvenue_Conf_ID == 0)
        {
			setCD_CcAvenue_Conf_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_CD_CcAvenue_Conf (Properties ctx, String CD_CcAvenue_Conf_UU, String trxName)
    {
      super (ctx, CD_CcAvenue_Conf_UU, trxName);
      /** if (CD_CcAvenue_Conf_UU == null)
        {
			setCD_CcAvenue_Conf_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_CD_CcAvenue_Conf (Properties ctx, String CD_CcAvenue_Conf_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, CD_CcAvenue_Conf_UU, trxName, virtualColumns);
      /** if (CD_CcAvenue_Conf_UU == null)
        {
			setCD_CcAvenue_Conf_ID (0);
        } */
    }

    /** Load Constructor */
    public X_CD_CcAvenue_Conf (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_CD_CcAvenue_Conf[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set CcAvenue Configuration.
		@param CD_CcAvenue_Conf_ID CcAvenue Configuration
	*/
	public void setCD_CcAvenue_Conf_ID (int CD_CcAvenue_Conf_ID)
	{
		if (CD_CcAvenue_Conf_ID < 1)
			set_ValueNoCheck (COLUMNNAME_CD_CcAvenue_Conf_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_CD_CcAvenue_Conf_ID, Integer.valueOf(CD_CcAvenue_Conf_ID));
	}

	/** Get CcAvenue Configuration.
		@return CcAvenue Configuration	  */
	public int getCD_CcAvenue_Conf_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_CD_CcAvenue_Conf_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set CD_CcAvenue_Conf_UU.
		@param CD_CcAvenue_Conf_UU CD_CcAvenue_Conf_UU
	*/
	public void setCD_CcAvenue_Conf_UU (String CD_CcAvenue_Conf_UU)
	{
		set_ValueNoCheck (COLUMNNAME_CD_CcAvenue_Conf_UU, CD_CcAvenue_Conf_UU);
	}

	/** Get CD_CcAvenue_Conf_UU.
		@return CD_CcAvenue_Conf_UU	  */
	public String getCD_CcAvenue_Conf_UU()
	{
		return (String)get_Value(COLUMNNAME_CD_CcAvenue_Conf_UU);
	}

	/** Set URL.
		@param URL Full URL address - e.g. http://www.idempiere.org
	*/
	public void setURL (String URL)
	{
		set_Value (COLUMNNAME_URL, URL);
	}

	/** Get URL.
		@return Full URL address - e.g. http://www.idempiere.org
	  */
	public String getURL()
	{
		return (String)get_Value(COLUMNNAME_URL);
	}

	/** Set accesscode.
		@param accesscode accesscode
	*/
	public void setaccesscode (String accesscode)
	{
		set_Value (COLUMNNAME_accesscode, accesscode);
	}

	/** Get accesscode.
		@return accesscode	  */
	public String getaccesscode()
	{
		return (String)get_Value(COLUMNNAME_accesscode);
	}

	/** Set merchantid.
		@param merchantid merchantid
	*/
	public void setmerchantid (String merchantid)
	{
		set_Value (COLUMNNAME_merchantid, merchantid);
	}

	/** Get merchantid.
		@return merchantid	  */
	public String getmerchantid()
	{
		return (String)get_Value(COLUMNNAME_merchantid);
	}

	/** Set workingkey.
		@param workingkey workingkey
	*/
	public void setworkingkey (String workingkey)
	{
		set_Value (COLUMNNAME_workingkey, workingkey);
	}

	/** Get workingkey.
		@return workingkey	  */
	public String getworkingkey()
	{
		return (String)get_Value(COLUMNNAME_workingkey);
	}
}