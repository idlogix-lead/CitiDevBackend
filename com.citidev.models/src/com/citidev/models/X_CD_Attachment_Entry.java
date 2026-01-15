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

/** Generated Model for CD_Attachment_Entry
 *  @author iDempiere (generated)
 *  @version Release 11 - $Id$ */
@org.adempiere.base.Model(table="CD_Attachment_Entry")
public class X_CD_Attachment_Entry extends PO implements I_CD_Attachment_Entry, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20251217L;

    /** Standard Constructor */
    public X_CD_Attachment_Entry (Properties ctx, int CD_Attachment_Entry_ID, String trxName)
    {
      super (ctx, CD_Attachment_Entry_ID, trxName);
      /** if (CD_Attachment_Entry_ID == 0)
        {
			setCD_Attachment_Entry_ID (0);
			setCD_GCS_DeleteComplete (false);
// N
			setCD_GCS_UploadComplete (false);
// N
			setCD_GCS_UploadDelete (false);
// N
			setName (null);
        } */
    }

    /** Standard Constructor */
    public X_CD_Attachment_Entry (Properties ctx, int CD_Attachment_Entry_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, CD_Attachment_Entry_ID, trxName, virtualColumns);
      /** if (CD_Attachment_Entry_ID == 0)
        {
			setCD_Attachment_Entry_ID (0);
			setCD_GCS_DeleteComplete (false);
// N
			setCD_GCS_UploadComplete (false);
// N
			setCD_GCS_UploadDelete (false);
// N
			setName (null);
        } */
    }

    /** Standard Constructor */
    public X_CD_Attachment_Entry (Properties ctx, String CD_Attachment_Entry_UU, String trxName)
    {
      super (ctx, CD_Attachment_Entry_UU, trxName);
      /** if (CD_Attachment_Entry_UU == null)
        {
			setCD_Attachment_Entry_ID (0);
			setCD_GCS_DeleteComplete (false);
// N
			setCD_GCS_UploadComplete (false);
// N
			setCD_GCS_UploadDelete (false);
// N
			setName (null);
        } */
    }

    /** Standard Constructor */
    public X_CD_Attachment_Entry (Properties ctx, String CD_Attachment_Entry_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, CD_Attachment_Entry_UU, trxName, virtualColumns);
      /** if (CD_Attachment_Entry_UU == null)
        {
			setCD_Attachment_Entry_ID (0);
			setCD_GCS_DeleteComplete (false);
// N
			setCD_GCS_UploadComplete (false);
// N
			setCD_GCS_UploadDelete (false);
// N
			setName (null);
        } */
    }

    /** Load Constructor */
    public X_CD_Attachment_Entry (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_CD_Attachment_Entry[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_Attachment getAD_Attachment() throws RuntimeException
	{
		return (org.compiere.model.I_AD_Attachment)MTable.get(getCtx(), org.compiere.model.I_AD_Attachment.Table_ID)
			.getPO(getAD_Attachment_ID(), get_TrxName());
	}

	/** Set Attachment.
		@param AD_Attachment_ID Attachment for the document
	*/
	public void setAD_Attachment_ID (int AD_Attachment_ID)
	{
		if (AD_Attachment_ID < 1)
			set_Value (COLUMNNAME_AD_Attachment_ID, null);
		else
			set_Value (COLUMNNAME_AD_Attachment_ID, Integer.valueOf(AD_Attachment_ID));
	}

	/** Get Attachment.
		@return Attachment for the document
	  */
	public int getAD_Attachment_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Attachment_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set CD_Attachment_Entry.
		@param CD_Attachment_Entry_ID CD_Attachment_Entry
	*/
	public void setCD_Attachment_Entry_ID (int CD_Attachment_Entry_ID)
	{
		if (CD_Attachment_Entry_ID < 1)
			set_ValueNoCheck (COLUMNNAME_CD_Attachment_Entry_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_CD_Attachment_Entry_ID, Integer.valueOf(CD_Attachment_Entry_ID));
	}

	/** Get CD_Attachment_Entry.
		@return CD_Attachment_Entry	  */
	public int getCD_Attachment_Entry_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_CD_Attachment_Entry_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set CD_Attachment_Entry_UU.
		@param CD_Attachment_Entry_UU CD_Attachment_Entry_UU
	*/
	public void setCD_Attachment_Entry_UU (String CD_Attachment_Entry_UU)
	{
		set_ValueNoCheck (COLUMNNAME_CD_Attachment_Entry_UU, CD_Attachment_Entry_UU);
	}

	/** Get CD_Attachment_Entry_UU.
		@return CD_Attachment_Entry_UU	  */
	public String getCD_Attachment_Entry_UU()
	{
		return (String)get_Value(COLUMNNAME_CD_Attachment_Entry_UU);
	}

	/** Set CD_GCS_BlobHash.
		@param CD_GCS_BlobHash CD_GCS_BlobHash
	*/
	public void setCD_GCS_BlobHash (String CD_GCS_BlobHash)
	{
		set_Value (COLUMNNAME_CD_GCS_BlobHash, CD_GCS_BlobHash);
	}

	/** Get CD_GCS_BlobHash.
		@return CD_GCS_BlobHash	  */
	public String getCD_GCS_BlobHash()
	{
		return (String)get_Value(COLUMNNAME_CD_GCS_BlobHash);
	}

	/** Set CD_GCS_BucketName.
		@param CD_GCS_BucketName CD_GCS_BucketName
	*/
	public void setCD_GCS_BucketName (String CD_GCS_BucketName)
	{
		set_Value (COLUMNNAME_CD_GCS_BucketName, CD_GCS_BucketName);
	}

	/** Get CD_GCS_BucketName.
		@return CD_GCS_BucketName	  */
	public String getCD_GCS_BucketName()
	{
		return (String)get_Value(COLUMNNAME_CD_GCS_BucketName);
	}

	/** Set CD_GCS_DeleteComplete.
		@param CD_GCS_DeleteComplete CD_GCS_DeleteComplete
	*/
	public void setCD_GCS_DeleteComplete (boolean CD_GCS_DeleteComplete)
	{
		set_Value (COLUMNNAME_CD_GCS_DeleteComplete, Boolean.valueOf(CD_GCS_DeleteComplete));
	}

	/** Get CD_GCS_DeleteComplete.
		@return CD_GCS_DeleteComplete	  */
	public boolean isCD_GCS_DeleteComplete()
	{
		Object oo = get_Value(COLUMNNAME_CD_GCS_DeleteComplete);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set CD_GCS_GCSUtilURI.
		@param CD_GCS_GCSUtilURI CD_GCS_GCSUtilURI
	*/
	public void setCD_GCS_GCSUtilURI (String CD_GCS_GCSUtilURI)
	{
		set_Value (COLUMNNAME_CD_GCS_GCSUtilURI, CD_GCS_GCSUtilURI);
	}

	/** Get CD_GCS_GCSUtilURI.
		@return CD_GCS_GCSUtilURI	  */
	public String getCD_GCS_GCSUtilURI()
	{
		return (String)get_Value(COLUMNNAME_CD_GCS_GCSUtilURI);
	}

	/** Set CD_GCS_MimeType.
		@param CD_GCS_MimeType CD_GCS_MimeType
	*/
	public void setCD_GCS_MimeType (String CD_GCS_MimeType)
	{
		set_Value (COLUMNNAME_CD_GCS_MimeType, CD_GCS_MimeType);
	}

	/** Get CD_GCS_MimeType.
		@return CD_GCS_MimeType	  */
	public String getCD_GCS_MimeType()
	{
		return (String)get_Value(COLUMNNAME_CD_GCS_MimeType);
	}

	/** Set CD_GCS_ObjectName.
		@param CD_GCS_ObjectName CD_GCS_ObjectName
	*/
	public void setCD_GCS_ObjectName (String CD_GCS_ObjectName)
	{
		set_Value (COLUMNNAME_CD_GCS_ObjectName, CD_GCS_ObjectName);
	}

	/** Get CD_GCS_ObjectName.
		@return CD_GCS_ObjectName	  */
	public String getCD_GCS_ObjectName()
	{
		return (String)get_Value(COLUMNNAME_CD_GCS_ObjectName);
	}

	/** Set CD_GCS_UploadComplete.
		@param CD_GCS_UploadComplete CD_GCS_UploadComplete
	*/
	public void setCD_GCS_UploadComplete (boolean CD_GCS_UploadComplete)
	{
		set_Value (COLUMNNAME_CD_GCS_UploadComplete, Boolean.valueOf(CD_GCS_UploadComplete));
	}

	/** Get CD_GCS_UploadComplete.
		@return CD_GCS_UploadComplete	  */
	public boolean isCD_GCS_UploadComplete()
	{
		Object oo = get_Value(COLUMNNAME_CD_GCS_UploadComplete);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set CD_GCS_UploadDelete.
		@param CD_GCS_UploadDelete CD_GCS_UploadDelete
	*/
	public void setCD_GCS_UploadDelete (boolean CD_GCS_UploadDelete)
	{
		set_Value (COLUMNNAME_CD_GCS_UploadDelete, Boolean.valueOf(CD_GCS_UploadDelete));
	}

	/** Get CD_GCS_UploadDelete.
		@return CD_GCS_UploadDelete	  */
	public boolean isCD_GCS_UploadDelete()
	{
		Object oo = get_Value(COLUMNNAME_CD_GCS_UploadDelete);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
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
}