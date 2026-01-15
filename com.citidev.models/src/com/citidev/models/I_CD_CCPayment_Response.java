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

/** Generated Interface for CD_CCPayment_Response
 *  @author iDempiere (generated) 
 *  @version Release 11
 */
@SuppressWarnings("all")
public interface I_CD_CCPayment_Response 
{

    /** TableName=CD_CCPayment_Response */
    public static final String Table_Name = "CD_CCPayment_Response";

    /** AD_Table_ID=1000024 */
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

    /** Column name Amount */
    public static final String COLUMNNAME_Amount = "Amount";

	/** Set Amount.
	  * Amount in a defined currency
	  */
	public void setAmount (BigDecimal Amount);

	/** Get Amount.
	  * Amount in a defined currency
	  */
	public BigDecimal getAmount();

    /** Column name CD_CCPayment_Response_ID */
    public static final String COLUMNNAME_CD_CCPayment_Response_ID = "CD_CCPayment_Response_ID";

	/** Set CD_CCPayment_Response	  */
	public void setCD_CCPayment_Response_ID (int CD_CCPayment_Response_ID);

	/** Get CD_CCPayment_Response	  */
	public int getCD_CCPayment_Response_ID();

    /** Column name CD_CCPayment_Response_UU */
    public static final String COLUMNNAME_CD_CCPayment_Response_UU = "CD_CCPayment_Response_UU";

	/** Set CD_CCPayment_Response_UU	  */
	public void setCD_CCPayment_Response_UU (String CD_CCPayment_Response_UU);

	/** Get CD_CCPayment_Response_UU	  */
	public String getCD_CCPayment_Response_UU();

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

    /** Column name Currency */
    public static final String COLUMNNAME_Currency = "Currency";

	/** Set Currency	  */
	public void setCurrency (String Currency);

	/** Get Currency	  */
	public String getCurrency();

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

    /** Column name acquirer_message */
    public static final String COLUMNNAME_acquirer_message = "acquirer_message";

	/** Set acquirer_message	  */
	public void setacquirer_message (String acquirer_message);

	/** Get acquirer_message	  */
	public String getacquirer_message();

    /** Column name bank_qsi_no */
    public static final String COLUMNNAME_bank_qsi_no = "bank_qsi_no";

	/** Set bank_qsi_no	  */
	public void setbank_qsi_no (String bank_qsi_no);

	/** Get bank_qsi_no	  */
	public String getbank_qsi_no();

    /** Column name bank_receipt_no */
    public static final String COLUMNNAME_bank_receipt_no = "bank_receipt_no";

	/** Set bank_receipt_no	  */
	public void setbank_receipt_no (String bank_receipt_no);

	/** Get bank_receipt_no	  */
	public String getbank_receipt_no();

    /** Column name bank_ref_no */
    public static final String COLUMNNAME_bank_ref_no = "bank_ref_no";

	/** Set bank_ref_no	  */
	public void setbank_ref_no (String bank_ref_no);

	/** Get bank_ref_no	  */
	public String getbank_ref_no();

    /** Column name billing_address */
    public static final String COLUMNNAME_billing_address = "billing_address";

	/** Set billing_address	  */
	public void setbilling_address (String billing_address);

	/** Get billing_address	  */
	public String getbilling_address();

    /** Column name billing_city */
    public static final String COLUMNNAME_billing_city = "billing_city";

	/** Set billing_city	  */
	public void setbilling_city (String billing_city);

	/** Get billing_city	  */
	public String getbilling_city();

    /** Column name billing_country */
    public static final String COLUMNNAME_billing_country = "billing_country";

	/** Set billing_country	  */
	public void setbilling_country (String billing_country);

	/** Get billing_country	  */
	public String getbilling_country();

    /** Column name billing_email */
    public static final String COLUMNNAME_billing_email = "billing_email";

	/** Set billing_email	  */
	public void setbilling_email (String billing_email);

	/** Get billing_email	  */
	public String getbilling_email();

    /** Column name billing_name */
    public static final String COLUMNNAME_billing_name = "billing_name";

	/** Set billing_name	  */
	public void setbilling_name (String billing_name);

	/** Get billing_name	  */
	public String getbilling_name();

    /** Column name billing_notes */
    public static final String COLUMNNAME_billing_notes = "billing_notes";

	/** Set billing_notes	  */
	public void setbilling_notes (String billing_notes);

	/** Get billing_notes	  */
	public String getbilling_notes();

    /** Column name billing_state */
    public static final String COLUMNNAME_billing_state = "billing_state";

	/** Set billing_state	  */
	public void setbilling_state (String billing_state);

	/** Get billing_state	  */
	public String getbilling_state();

    /** Column name billing_tel */
    public static final String COLUMNNAME_billing_tel = "billing_tel";

	/** Set billing_tel	  */
	public void setbilling_tel (String billing_tel);

	/** Get billing_tel	  */
	public String getbilling_tel();

    /** Column name billing_zip */
    public static final String COLUMNNAME_billing_zip = "billing_zip";

	/** Set billing_zip	  */
	public void setbilling_zip (String billing_zip);

	/** Get billing_zip	  */
	public String getbilling_zip();

    /** Column name card_holder_name */
    public static final String COLUMNNAME_card_holder_name = "card_holder_name";

	/** Set card_holder_name	  */
	public void setcard_holder_name (String card_holder_name);

	/** Get card_holder_name	  */
	public String getcard_holder_name();

    /** Column name card_name */
    public static final String COLUMNNAME_card_name = "card_name";

	/** Set card_name	  */
	public void setcard_name (String card_name);

	/** Get card_name	  */
	public String getcard_name();

    /** Column name customer_cardid */
    public static final String COLUMNNAME_customer_cardid = "customer_cardid";

	/** Set customer_cardid	  */
	public void setcustomer_cardid (String customer_cardid);

	/** Get customer_cardid	  */
	public String getcustomer_cardid();

    /** Column name delivery_address */
    public static final String COLUMNNAME_delivery_address = "delivery_address";

	/** Set delivery_address	  */
	public void setdelivery_address (String delivery_address);

	/** Get delivery_address	  */
	public String getdelivery_address();

    /** Column name delivery_city */
    public static final String COLUMNNAME_delivery_city = "delivery_city";

	/** Set delivery_city	  */
	public void setdelivery_city (String delivery_city);

	/** Get delivery_city	  */
	public String getdelivery_city();

    /** Column name delivery_country */
    public static final String COLUMNNAME_delivery_country = "delivery_country";

	/** Set delivery_country	  */
	public void setdelivery_country (String delivery_country);

	/** Get delivery_country	  */
	public String getdelivery_country();

    /** Column name delivery_name */
    public static final String COLUMNNAME_delivery_name = "delivery_name";

	/** Set delivery_name	  */
	public void setdelivery_name (String delivery_name);

	/** Get delivery_name	  */
	public String getdelivery_name();

    /** Column name delivery_state */
    public static final String COLUMNNAME_delivery_state = "delivery_state";

	/** Set delivery_state	  */
	public void setdelivery_state (String delivery_state);

	/** Get delivery_state	  */
	public String getdelivery_state();

    /** Column name delivery_tel */
    public static final String COLUMNNAME_delivery_tel = "delivery_tel";

	/** Set delivery_tel	  */
	public void setdelivery_tel (String delivery_tel);

	/** Get delivery_tel	  */
	public String getdelivery_tel();

    /** Column name delivery_zip */
    public static final String COLUMNNAME_delivery_zip = "delivery_zip";

	/** Set delivery_zip	  */
	public void setdelivery_zip (String delivery_zip);

	/** Get delivery_zip	  */
	public String getdelivery_zip();

    /** Column name discount_value */
    public static final String COLUMNNAME_discount_value = "discount_value";

	/** Set discount_value	  */
	public void setdiscount_value (BigDecimal discount_value);

	/** Get discount_value	  */
	public BigDecimal getdiscount_value();

    /** Column name eci_value */
    public static final String COLUMNNAME_eci_value = "eci_value";

	/** Set eci_value	  */
	public void seteci_value (String eci_value);

	/** Get eci_value	  */
	public String geteci_value();

    /** Column name failure_message */
    public static final String COLUMNNAME_failure_message = "failure_message";

	/** Set failure_message	  */
	public void setfailure_message (String failure_message);

	/** Get failure_message	  */
	public String getfailure_message();

    /** Column name inv_mer_reference_no */
    public static final String COLUMNNAME_inv_mer_reference_no = "inv_mer_reference_no";

	/** Set inv_mer_reference_no	  */
	public void setinv_mer_reference_no (String inv_mer_reference_no);

	/** Get inv_mer_reference_no	  */
	public String getinv_mer_reference_no();

    /** Column name is_mcp_txn */
    public static final String COLUMNNAME_is_mcp_txn = "is_mcp_txn";

	/** Set is_mcp_txn	  */
	public void setis_mcp_txn (boolean is_mcp_txn);

	/** Get is_mcp_txn	  */
	public boolean is_mcp_txn();

    /** Column name issuer */
    public static final String COLUMNNAME_issuer = "issuer";

	/** Set issuer	  */
	public void setissuer (String issuer);

	/** Get issuer	  */
	public String getissuer();

    /** Column name mcp_amount */
    public static final String COLUMNNAME_mcp_amount = "mcp_amount";

	/** Set mcp_amount	  */
	public void setmcp_amount (BigDecimal mcp_amount);

	/** Get mcp_amount	  */
	public BigDecimal getmcp_amount();

    /** Column name mcp_conversion_rate */
    public static final String COLUMNNAME_mcp_conversion_rate = "mcp_conversion_rate";

	/** Set mcp_conversion_rate	  */
	public void setmcp_conversion_rate (BigDecimal mcp_conversion_rate);

	/** Get mcp_conversion_rate	  */
	public BigDecimal getmcp_conversion_rate();

    /** Column name mcp_currency */
    public static final String COLUMNNAME_mcp_currency = "mcp_currency";

	/** Set mcp_currency	  */
	public void setmcp_currency (String mcp_currency);

	/** Get mcp_currency	  */
	public String getmcp_currency();

    /** Column name mer_amount */
    public static final String COLUMNNAME_mer_amount = "mer_amount";

	/** Set mer_amount	  */
	public void setmer_amount (BigDecimal mer_amount);

	/** Get mer_amount	  */
	public BigDecimal getmer_amount();

    /** Column name merchant_param1 */
    public static final String COLUMNNAME_merchant_param1 = "merchant_param1";

	/** Set merchant_param1	  */
	public void setmerchant_param1 (String merchant_param1);

	/** Get merchant_param1	  */
	public String getmerchant_param1();

    /** Column name merchant_param2 */
    public static final String COLUMNNAME_merchant_param2 = "merchant_param2";

	/** Set merchant_param2	  */
	public void setmerchant_param2 (String merchant_param2);

	/** Get merchant_param2	  */
	public String getmerchant_param2();

    /** Column name merchant_param3 */
    public static final String COLUMNNAME_merchant_param3 = "merchant_param3";

	/** Set merchant_param3	  */
	public void setmerchant_param3 (String merchant_param3);

	/** Get merchant_param3	  */
	public String getmerchant_param3();

    /** Column name merchant_param4 */
    public static final String COLUMNNAME_merchant_param4 = "merchant_param4";

	/** Set merchant_param4	  */
	public void setmerchant_param4 (String merchant_param4);

	/** Get merchant_param4	  */
	public String getmerchant_param4();

    /** Column name merchant_param5 */
    public static final String COLUMNNAME_merchant_param5 = "merchant_param5";

	/** Set merchant_param5	  */
	public void setmerchant_param5 (String merchant_param5);

	/** Get merchant_param5	  */
	public String getmerchant_param5();

    /** Column name merchant_param6 */
    public static final String COLUMNNAME_merchant_param6 = "merchant_param6";

	/** Set merchant_param6	  */
	public void setmerchant_param6 (String merchant_param6);

	/** Get merchant_param6	  */
	public String getmerchant_param6();

    /** Column name offer_code */
    public static final String COLUMNNAME_offer_code = "offer_code";

	/** Set offer_code	  */
	public void setoffer_code (String offer_code);

	/** Get offer_code	  */
	public String getoffer_code();

    /** Column name offer_type */
    public static final String COLUMNNAME_offer_type = "offer_type";

	/** Set offer_type	  */
	public void setoffer_type (String offer_type);

	/** Get offer_type	  */
	public String getoffer_type();

    /** Column name order_status */
    public static final String COLUMNNAME_order_status = "order_status";

	/** Set order_status	  */
	public void setorder_status (String order_status);

	/** Get order_status	  */
	public String getorder_status();

    /** Column name orderid */
    public static final String COLUMNNAME_orderid = "orderid";

	/** Set orderid	  */
	public void setorderid (String orderid);

	/** Get orderid	  */
	public String getorderid();

    /** Column name payment_mode */
    public static final String COLUMNNAME_payment_mode = "payment_mode";

	/** Set payment_mode	  */
	public void setpayment_mode (String payment_mode);

	/** Get payment_mode	  */
	public String getpayment_mode();

    /** Column name si_created */
    public static final String COLUMNNAME_si_created = "si_created";

	/** Set si_created	  */
	public void setsi_created (Timestamp si_created);

	/** Get si_created	  */
	public Timestamp getsi_created();

    /** Column name si_mer_ref_no */
    public static final String COLUMNNAME_si_mer_ref_no = "si_mer_ref_no";

	/** Set si_mer_ref_no	  */
	public void setsi_mer_ref_no (String si_mer_ref_no);

	/** Get si_mer_ref_no	  */
	public String getsi_mer_ref_no();

    /** Column name si_ref_no */
    public static final String COLUMNNAME_si_ref_no = "si_ref_no";

	/** Set si_ref_no	  */
	public void setsi_ref_no (String si_ref_no);

	/** Get si_ref_no	  */
	public String getsi_ref_no();

    /** Column name si_status */
    public static final String COLUMNNAME_si_status = "si_status";

	/** Set si_status	  */
	public void setsi_status (String si_status);

	/** Get si_status	  */
	public String getsi_status();

    /** Column name status_code */
    public static final String COLUMNNAME_status_code = "status_code";

	/** Set status_code	  */
	public void setstatus_code (String status_code);

	/** Get status_code	  */
	public String getstatus_code();

    /** Column name status_message */
    public static final String COLUMNNAME_status_message = "status_message";

	/** Set status_message	  */
	public void setstatus_message (String status_message);

	/** Get status_message	  */
	public String getstatus_message();

    /** Column name trackingid */
    public static final String COLUMNNAME_trackingid = "trackingid";

	/** Set trackingid	  */
	public void settrackingid (String trackingid);

	/** Get trackingid	  */
	public String gettrackingid();

    /** Column name vault */
    public static final String COLUMNNAME_vault = "vault";

	/** Set vault	  */
	public void setvault (boolean vault);

	/** Get vault	  */
	public boolean isvault();

    /** Column name visaeppamt */
    public static final String COLUMNNAME_visaeppamt = "visaeppamt";

	/** Set visaeppamt	  */
	public void setvisaeppamt (BigDecimal visaeppamt);

	/** Get visaeppamt	  */
	public BigDecimal getvisaeppamt();

    /** Column name visaeppfees */
    public static final String COLUMNNAME_visaeppfees = "visaeppfees";

	/** Set visaeppfees	  */
	public void setvisaeppfees (BigDecimal visaeppfees);

	/** Get visaeppfees	  */
	public BigDecimal getvisaeppfees();

    /** Column name visaeppfrequency */
    public static final String COLUMNNAME_visaeppfrequency = "visaeppfrequency";

	/** Set visaeppfrequency	  */
	public void setvisaeppfrequency (String visaeppfrequency);

	/** Get visaeppfrequency	  */
	public String getvisaeppfrequency();

    /** Column name visaepprate */
    public static final String COLUMNNAME_visaepprate = "visaepprate";

	/** Set visaepprate	  */
	public void setvisaepprate (BigDecimal visaepprate);

	/** Get visaepprate	  */
	public BigDecimal getvisaepprate();

    /** Column name visaepptenure */
    public static final String COLUMNNAME_visaepptenure = "visaepptenure";

	/** Set visaepptenure	  */
	public void setvisaepptenure (String visaepptenure);

	/** Get visaepptenure	  */
	public String getvisaepptenure();

    /** Column name visaeppterms */
    public static final String COLUMNNAME_visaeppterms = "visaeppterms";

	/** Set visaeppterms	  */
	public void setvisaeppterms (String visaeppterms);

	/** Get visaeppterms	  */
	public String getvisaeppterms();

    /** Column name visaplanacceptanceid */
    public static final String COLUMNNAME_visaplanacceptanceid = "visaplanacceptanceid";

	/** Set visaplanacceptanceid	  */
	public void setvisaplanacceptanceid (String visaplanacceptanceid);

	/** Get visaplanacceptanceid	  */
	public String getvisaplanacceptanceid();

    /** Column name visaplanid */
    public static final String COLUMNNAME_visaplanid = "visaplanid";

	/** Set visaplanid	  */
	public void setvisaplanid (String visaplanid);

	/** Get visaplanid	  */
	public String getvisaplanid();
}
