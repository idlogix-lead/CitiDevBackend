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

/** Generated Interface for CD_Attachment_Entry
 *  @author iDempiere (generated) 
 *  @version Release 11
 */
@SuppressWarnings("all")
public interface I_CD_Attachment_Entry 
{

    /** TableName=CD_Attachment_Entry */
    public static final String Table_Name = "CD_Attachment_Entry";

    /** AD_Table_ID=1000022 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

    /** Column name AD_Attachment_ID */
    public static final String COLUMNNAME_AD_Attachment_ID = "AD_Attachment_ID";

	/** Set Attachment.
	  * Attachment for the document
	  */
	public void setAD_Attachment_ID (int AD_Attachment_ID);

	/** Get Attachment.
	  * Attachment for the document
	  */
	public int getAD_Attachment_ID();

	public org.compiere.model.I_AD_Attachment getAD_Attachment() throws RuntimeException;

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

    /** Column name CD_Attachment_Entry_ID */
    public static final String COLUMNNAME_CD_Attachment_Entry_ID = "CD_Attachment_Entry_ID";

	/** Set CD_Attachment_Entry	  */
	public void setCD_Attachment_Entry_ID (int CD_Attachment_Entry_ID);

	/** Get CD_Attachment_Entry	  */
	public int getCD_Attachment_Entry_ID();

    /** Column name CD_Attachment_Entry_UU */
    public static final String COLUMNNAME_CD_Attachment_Entry_UU = "CD_Attachment_Entry_UU";

	/** Set CD_Attachment_Entry_UU	  */
	public void setCD_Attachment_Entry_UU (String CD_Attachment_Entry_UU);

	/** Get CD_Attachment_Entry_UU	  */
	public String getCD_Attachment_Entry_UU();

    /** Column name CD_GCS_BlobHash */
    public static final String COLUMNNAME_CD_GCS_BlobHash = "CD_GCS_BlobHash";

	/** Set CD_GCS_BlobHash	  */
	public void setCD_GCS_BlobHash (String CD_GCS_BlobHash);

	/** Get CD_GCS_BlobHash	  */
	public String getCD_GCS_BlobHash();

    /** Column name CD_GCS_BucketName */
    public static final String COLUMNNAME_CD_GCS_BucketName = "CD_GCS_BucketName";

	/** Set CD_GCS_BucketName	  */
	public void setCD_GCS_BucketName (String CD_GCS_BucketName);

	/** Get CD_GCS_BucketName	  */
	public String getCD_GCS_BucketName();

    /** Column name CD_GCS_DeleteComplete */
    public static final String COLUMNNAME_CD_GCS_DeleteComplete = "CD_GCS_DeleteComplete";

	/** Set CD_GCS_DeleteComplete	  */
	public void setCD_GCS_DeleteComplete (boolean CD_GCS_DeleteComplete);

	/** Get CD_GCS_DeleteComplete	  */
	public boolean isCD_GCS_DeleteComplete();

    /** Column name CD_GCS_GCSUtilURI */
    public static final String COLUMNNAME_CD_GCS_GCSUtilURI = "CD_GCS_GCSUtilURI";

	/** Set CD_GCS_GCSUtilURI	  */
	public void setCD_GCS_GCSUtilURI (String CD_GCS_GCSUtilURI);

	/** Get CD_GCS_GCSUtilURI	  */
	public String getCD_GCS_GCSUtilURI();

    /** Column name CD_GCS_MimeType */
    public static final String COLUMNNAME_CD_GCS_MimeType = "CD_GCS_MimeType";

	/** Set CD_GCS_MimeType	  */
	public void setCD_GCS_MimeType (String CD_GCS_MimeType);

	/** Get CD_GCS_MimeType	  */
	public String getCD_GCS_MimeType();

    /** Column name CD_GCS_ObjectName */
    public static final String COLUMNNAME_CD_GCS_ObjectName = "CD_GCS_ObjectName";

	/** Set CD_GCS_ObjectName	  */
	public void setCD_GCS_ObjectName (String CD_GCS_ObjectName);

	/** Get CD_GCS_ObjectName	  */
	public String getCD_GCS_ObjectName();

    /** Column name CD_GCS_UploadComplete */
    public static final String COLUMNNAME_CD_GCS_UploadComplete = "CD_GCS_UploadComplete";

	/** Set CD_GCS_UploadComplete	  */
	public void setCD_GCS_UploadComplete (boolean CD_GCS_UploadComplete);

	/** Get CD_GCS_UploadComplete	  */
	public boolean isCD_GCS_UploadComplete();

    /** Column name CD_GCS_UploadDelete */
    public static final String COLUMNNAME_CD_GCS_UploadDelete = "CD_GCS_UploadDelete";

	/** Set CD_GCS_UploadDelete	  */
	public void setCD_GCS_UploadDelete (boolean CD_GCS_UploadDelete);

	/** Get CD_GCS_UploadDelete	  */
	public boolean isCD_GCS_UploadDelete();

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

    /** Column name Name */
    public static final String COLUMNNAME_Name = "Name";

	/** Set Name.
	  * Alphanumeric identifier of the entity
	  */
	public void setName (String Name);

	/** Get Name.
	  * Alphanumeric identifier of the entity
	  */
	public String getName();

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
}
