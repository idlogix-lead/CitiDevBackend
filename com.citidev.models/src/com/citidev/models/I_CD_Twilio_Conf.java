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

/** Generated Interface for CD_Twilio_Conf
 *  @author iDempiere (generated) 
 *  @version Release 11
 */
@SuppressWarnings("all")
public interface I_CD_Twilio_Conf 
{

    /** TableName=CD_Twilio_Conf */
    public static final String Table_Name = "CD_Twilio_Conf";

    /** AD_Table_ID=1000020 */
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

    /** Column name CD_Twilio_Conf_ID */
    public static final String COLUMNNAME_CD_Twilio_Conf_ID = "CD_Twilio_Conf_ID";

	/** Set CD_Twilio_Conf	  */
	public void setCD_Twilio_Conf_ID (int CD_Twilio_Conf_ID);

	/** Get CD_Twilio_Conf	  */
	public int getCD_Twilio_Conf_ID();

    /** Column name CD_Twilio_Conf_UU */
    public static final String COLUMNNAME_CD_Twilio_Conf_UU = "CD_Twilio_Conf_UU";

	/** Set CD_Twilio_Conf_UU	  */
	public void setCD_Twilio_Conf_UU (String CD_Twilio_Conf_UU);

	/** Get CD_Twilio_Conf_UU	  */
	public String getCD_Twilio_Conf_UU();

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

    /** Column name twilio_account_sid */
    public static final String COLUMNNAME_twilio_account_sid = "twilio_account_sid";

	/** Set twilio_account_sid	  */
	public void settwilio_account_sid (String twilio_account_sid);

	/** Get twilio_account_sid	  */
	public String gettwilio_account_sid();

    /** Column name twilio_auth_token */
    public static final String COLUMNNAME_twilio_auth_token = "twilio_auth_token";

	/** Set twilio_auth_token	  */
	public void settwilio_auth_token (String twilio_auth_token);

	/** Get twilio_auth_token	  */
	public String gettwilio_auth_token();

    /** Column name twilio_whatsapp_number */
    public static final String COLUMNNAME_twilio_whatsapp_number = "twilio_whatsapp_number";

	/** Set twilio_whatsapp_number	  */
	public void settwilio_whatsapp_number (String twilio_whatsapp_number);

	/** Get twilio_whatsapp_number	  */
	public String gettwilio_whatsapp_number();
}
