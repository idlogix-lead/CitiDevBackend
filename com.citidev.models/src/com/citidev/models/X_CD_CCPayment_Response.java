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

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;

/** Generated Model for CD_CCPayment_Response
 *  @author iDempiere (generated)
 *  @version Release 11 - $Id$ */
@org.adempiere.base.Model(table="CD_CCPayment_Response")
public class X_CD_CCPayment_Response extends PO implements I_CD_CCPayment_Response, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20251231L;

    /** Standard Constructor */
    public X_CD_CCPayment_Response (Properties ctx, int CD_CCPayment_Response_ID, String trxName)
    {
      super (ctx, CD_CCPayment_Response_ID, trxName);
      /** if (CD_CCPayment_Response_ID == 0)
        {
			setCD_CCPayment_Response_ID (0);
			setis_mcp_txn (false);
// N
			setvault (false);
// N
        } */
    }

    /** Standard Constructor */
    public X_CD_CCPayment_Response (Properties ctx, int CD_CCPayment_Response_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, CD_CCPayment_Response_ID, trxName, virtualColumns);
      /** if (CD_CCPayment_Response_ID == 0)
        {
			setCD_CCPayment_Response_ID (0);
			setis_mcp_txn (false);
// N
			setvault (false);
// N
        } */
    }

    /** Standard Constructor */
    public X_CD_CCPayment_Response (Properties ctx, String CD_CCPayment_Response_UU, String trxName)
    {
      super (ctx, CD_CCPayment_Response_UU, trxName);
      /** if (CD_CCPayment_Response_UU == null)
        {
			setCD_CCPayment_Response_ID (0);
			setis_mcp_txn (false);
// N
			setvault (false);
// N
        } */
    }

    /** Standard Constructor */
    public X_CD_CCPayment_Response (Properties ctx, String CD_CCPayment_Response_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, CD_CCPayment_Response_UU, trxName, virtualColumns);
      /** if (CD_CCPayment_Response_UU == null)
        {
			setCD_CCPayment_Response_ID (0);
			setis_mcp_txn (false);
// N
			setvault (false);
// N
        } */
    }

    /** Load Constructor */
    public X_CD_CCPayment_Response (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_CD_CCPayment_Response[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Amount.
		@param Amount Amount in a defined currency
	*/
	public void setAmount (BigDecimal Amount)
	{
		set_ValueNoCheck (COLUMNNAME_Amount, Amount);
	}

	/** Get Amount.
		@return Amount in a defined currency
	  */
	public BigDecimal getAmount()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Amount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set CD_CCPayment_Response.
		@param CD_CCPayment_Response_ID CD_CCPayment_Response
	*/
	public void setCD_CCPayment_Response_ID (int CD_CCPayment_Response_ID)
	{
		if (CD_CCPayment_Response_ID < 1)
			set_ValueNoCheck (COLUMNNAME_CD_CCPayment_Response_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_CD_CCPayment_Response_ID, Integer.valueOf(CD_CCPayment_Response_ID));
	}

	/** Get CD_CCPayment_Response.
		@return CD_CCPayment_Response	  */
	public int getCD_CCPayment_Response_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_CD_CCPayment_Response_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set CD_CCPayment_Response_UU.
		@param CD_CCPayment_Response_UU CD_CCPayment_Response_UU
	*/
	public void setCD_CCPayment_Response_UU (String CD_CCPayment_Response_UU)
	{
		set_ValueNoCheck (COLUMNNAME_CD_CCPayment_Response_UU, CD_CCPayment_Response_UU);
	}

	/** Get CD_CCPayment_Response_UU.
		@return CD_CCPayment_Response_UU	  */
	public String getCD_CCPayment_Response_UU()
	{
		return (String)get_Value(COLUMNNAME_CD_CCPayment_Response_UU);
	}

	/** Set Currency.
		@param Currency Currency
	*/
	public void setCurrency (String Currency)
	{
		set_ValueNoCheck (COLUMNNAME_Currency, Currency);
	}

	/** Get Currency.
		@return Currency	  */
	public String getCurrency()
	{
		return (String)get_Value(COLUMNNAME_Currency);
	}

	/** Set acquirer_message.
		@param acquirer_message acquirer_message
	*/
	public void setacquirer_message (String acquirer_message)
	{
		set_Value (COLUMNNAME_acquirer_message, acquirer_message);
	}

	/** Get acquirer_message.
		@return acquirer_message	  */
	public String getacquirer_message()
	{
		return (String)get_Value(COLUMNNAME_acquirer_message);
	}

	/** Set bank_qsi_no.
		@param bank_qsi_no bank_qsi_no
	*/
	public void setbank_qsi_no (String bank_qsi_no)
	{
		set_Value (COLUMNNAME_bank_qsi_no, bank_qsi_no);
	}

	/** Get bank_qsi_no.
		@return bank_qsi_no	  */
	public String getbank_qsi_no()
	{
		return (String)get_Value(COLUMNNAME_bank_qsi_no);
	}

	/** Set bank_receipt_no.
		@param bank_receipt_no bank_receipt_no
	*/
	public void setbank_receipt_no (String bank_receipt_no)
	{
		set_Value (COLUMNNAME_bank_receipt_no, bank_receipt_no);
	}

	/** Get bank_receipt_no.
		@return bank_receipt_no	  */
	public String getbank_receipt_no()
	{
		return (String)get_Value(COLUMNNAME_bank_receipt_no);
	}

	/** Set bank_ref_no.
		@param bank_ref_no bank_ref_no
	*/
	public void setbank_ref_no (String bank_ref_no)
	{
		set_Value (COLUMNNAME_bank_ref_no, bank_ref_no);
	}

	/** Get bank_ref_no.
		@return bank_ref_no	  */
	public String getbank_ref_no()
	{
		return (String)get_Value(COLUMNNAME_bank_ref_no);
	}

	/** Set billing_address.
		@param billing_address billing_address
	*/
	public void setbilling_address (String billing_address)
	{
		set_Value (COLUMNNAME_billing_address, billing_address);
	}

	/** Get billing_address.
		@return billing_address	  */
	public String getbilling_address()
	{
		return (String)get_Value(COLUMNNAME_billing_address);
	}

	/** Set billing_city.
		@param billing_city billing_city
	*/
	public void setbilling_city (String billing_city)
	{
		set_Value (COLUMNNAME_billing_city, billing_city);
	}

	/** Get billing_city.
		@return billing_city	  */
	public String getbilling_city()
	{
		return (String)get_Value(COLUMNNAME_billing_city);
	}

	/** Set billing_country.
		@param billing_country billing_country
	*/
	public void setbilling_country (String billing_country)
	{
		set_Value (COLUMNNAME_billing_country, billing_country);
	}

	/** Get billing_country.
		@return billing_country	  */
	public String getbilling_country()
	{
		return (String)get_Value(COLUMNNAME_billing_country);
	}

	/** Set billing_email.
		@param billing_email billing_email
	*/
	public void setbilling_email (String billing_email)
	{
		set_Value (COLUMNNAME_billing_email, billing_email);
	}

	/** Get billing_email.
		@return billing_email	  */
	public String getbilling_email()
	{
		return (String)get_Value(COLUMNNAME_billing_email);
	}

	/** Set billing_name.
		@param billing_name billing_name
	*/
	public void setbilling_name (String billing_name)
	{
		set_Value (COLUMNNAME_billing_name, billing_name);
	}

	/** Get billing_name.
		@return billing_name	  */
	public String getbilling_name()
	{
		return (String)get_Value(COLUMNNAME_billing_name);
	}

	/** Set billing_notes.
		@param billing_notes billing_notes
	*/
	public void setbilling_notes (String billing_notes)
	{
		set_Value (COLUMNNAME_billing_notes, billing_notes);
	}

	/** Get billing_notes.
		@return billing_notes	  */
	public String getbilling_notes()
	{
		return (String)get_Value(COLUMNNAME_billing_notes);
	}

	/** Set billing_state.
		@param billing_state billing_state
	*/
	public void setbilling_state (String billing_state)
	{
		set_Value (COLUMNNAME_billing_state, billing_state);
	}

	/** Get billing_state.
		@return billing_state	  */
	public String getbilling_state()
	{
		return (String)get_Value(COLUMNNAME_billing_state);
	}

	/** Set billing_tel.
		@param billing_tel billing_tel
	*/
	public void setbilling_tel (String billing_tel)
	{
		set_Value (COLUMNNAME_billing_tel, billing_tel);
	}

	/** Get billing_tel.
		@return billing_tel	  */
	public String getbilling_tel()
	{
		return (String)get_Value(COLUMNNAME_billing_tel);
	}

	/** Set billing_zip.
		@param billing_zip billing_zip
	*/
	public void setbilling_zip (String billing_zip)
	{
		set_Value (COLUMNNAME_billing_zip, billing_zip);
	}

	/** Get billing_zip.
		@return billing_zip	  */
	public String getbilling_zip()
	{
		return (String)get_Value(COLUMNNAME_billing_zip);
	}

	/** Set card_holder_name.
		@param card_holder_name card_holder_name
	*/
	public void setcard_holder_name (String card_holder_name)
	{
		set_Value (COLUMNNAME_card_holder_name, card_holder_name);
	}

	/** Get card_holder_name.
		@return card_holder_name	  */
	public String getcard_holder_name()
	{
		return (String)get_Value(COLUMNNAME_card_holder_name);
	}

	/** Set card_name.
		@param card_name card_name
	*/
	public void setcard_name (String card_name)
	{
		set_Value (COLUMNNAME_card_name, card_name);
	}

	/** Get card_name.
		@return card_name	  */
	public String getcard_name()
	{
		return (String)get_Value(COLUMNNAME_card_name);
	}

	/** Set customer_cardid.
		@param customer_cardid customer_cardid
	*/
	public void setcustomer_cardid (String customer_cardid)
	{
		set_Value (COLUMNNAME_customer_cardid, customer_cardid);
	}

	/** Get customer_cardid.
		@return customer_cardid	  */
	public String getcustomer_cardid()
	{
		return (String)get_Value(COLUMNNAME_customer_cardid);
	}

	/** Set delivery_address.
		@param delivery_address delivery_address
	*/
	public void setdelivery_address (String delivery_address)
	{
		set_Value (COLUMNNAME_delivery_address, delivery_address);
	}

	/** Get delivery_address.
		@return delivery_address	  */
	public String getdelivery_address()
	{
		return (String)get_Value(COLUMNNAME_delivery_address);
	}

	/** Set delivery_city.
		@param delivery_city delivery_city
	*/
	public void setdelivery_city (String delivery_city)
	{
		set_Value (COLUMNNAME_delivery_city, delivery_city);
	}

	/** Get delivery_city.
		@return delivery_city	  */
	public String getdelivery_city()
	{
		return (String)get_Value(COLUMNNAME_delivery_city);
	}

	/** Set delivery_country.
		@param delivery_country delivery_country
	*/
	public void setdelivery_country (String delivery_country)
	{
		set_Value (COLUMNNAME_delivery_country, delivery_country);
	}

	/** Get delivery_country.
		@return delivery_country	  */
	public String getdelivery_country()
	{
		return (String)get_Value(COLUMNNAME_delivery_country);
	}

	/** Set delivery_name.
		@param delivery_name delivery_name
	*/
	public void setdelivery_name (String delivery_name)
	{
		set_Value (COLUMNNAME_delivery_name, delivery_name);
	}

	/** Get delivery_name.
		@return delivery_name	  */
	public String getdelivery_name()
	{
		return (String)get_Value(COLUMNNAME_delivery_name);
	}

	/** Set delivery_state.
		@param delivery_state delivery_state
	*/
	public void setdelivery_state (String delivery_state)
	{
		set_Value (COLUMNNAME_delivery_state, delivery_state);
	}

	/** Get delivery_state.
		@return delivery_state	  */
	public String getdelivery_state()
	{
		return (String)get_Value(COLUMNNAME_delivery_state);
	}

	/** Set delivery_tel.
		@param delivery_tel delivery_tel
	*/
	public void setdelivery_tel (String delivery_tel)
	{
		set_Value (COLUMNNAME_delivery_tel, delivery_tel);
	}

	/** Get delivery_tel.
		@return delivery_tel	  */
	public String getdelivery_tel()
	{
		return (String)get_Value(COLUMNNAME_delivery_tel);
	}

	/** Set delivery_zip.
		@param delivery_zip delivery_zip
	*/
	public void setdelivery_zip (String delivery_zip)
	{
		set_Value (COLUMNNAME_delivery_zip, delivery_zip);
	}

	/** Get delivery_zip.
		@return delivery_zip	  */
	public String getdelivery_zip()
	{
		return (String)get_Value(COLUMNNAME_delivery_zip);
	}

	/** Set discount_value.
		@param discount_value discount_value
	*/
	public void setdiscount_value (BigDecimal discount_value)
	{
		set_Value (COLUMNNAME_discount_value, discount_value);
	}

	/** Get discount_value.
		@return discount_value	  */
	public BigDecimal getdiscount_value()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_discount_value);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set eci_value.
		@param eci_value eci_value
	*/
	public void seteci_value (String eci_value)
	{
		set_Value (COLUMNNAME_eci_value, eci_value);
	}

	/** Get eci_value.
		@return eci_value	  */
	public String geteci_value()
	{
		return (String)get_Value(COLUMNNAME_eci_value);
	}

	/** Set failure_message.
		@param failure_message failure_message
	*/
	public void setfailure_message (String failure_message)
	{
		set_Value (COLUMNNAME_failure_message, failure_message);
	}

	/** Get failure_message.
		@return failure_message	  */
	public String getfailure_message()
	{
		return (String)get_Value(COLUMNNAME_failure_message);
	}

	/** Set inv_mer_reference_no.
		@param inv_mer_reference_no inv_mer_reference_no
	*/
	public void setinv_mer_reference_no (String inv_mer_reference_no)
	{
		set_Value (COLUMNNAME_inv_mer_reference_no, inv_mer_reference_no);
	}

	/** Get inv_mer_reference_no.
		@return inv_mer_reference_no	  */
	public String getinv_mer_reference_no()
	{
		return (String)get_Value(COLUMNNAME_inv_mer_reference_no);
	}

	/** Set is_mcp_txn.
		@param is_mcp_txn is_mcp_txn
	*/
	public void setis_mcp_txn (boolean is_mcp_txn)
	{
		set_Value (COLUMNNAME_is_mcp_txn, Boolean.valueOf(is_mcp_txn));
	}

	/** Get is_mcp_txn.
		@return is_mcp_txn	  */
	public boolean is_mcp_txn()
	{
		Object oo = get_Value(COLUMNNAME_is_mcp_txn);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set issuer.
		@param issuer issuer
	*/
	public void setissuer (String issuer)
	{
		set_Value (COLUMNNAME_issuer, issuer);
	}

	/** Get issuer.
		@return issuer	  */
	public String getissuer()
	{
		return (String)get_Value(COLUMNNAME_issuer);
	}

	/** Set mcp_amount.
		@param mcp_amount mcp_amount
	*/
	public void setmcp_amount (BigDecimal mcp_amount)
	{
		set_Value (COLUMNNAME_mcp_amount, mcp_amount);
	}

	/** Get mcp_amount.
		@return mcp_amount	  */
	public BigDecimal getmcp_amount()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_mcp_amount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set mcp_conversion_rate.
		@param mcp_conversion_rate mcp_conversion_rate
	*/
	public void setmcp_conversion_rate (BigDecimal mcp_conversion_rate)
	{
		set_Value (COLUMNNAME_mcp_conversion_rate, mcp_conversion_rate);
	}

	/** Get mcp_conversion_rate.
		@return mcp_conversion_rate	  */
	public BigDecimal getmcp_conversion_rate()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_mcp_conversion_rate);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set mcp_currency.
		@param mcp_currency mcp_currency
	*/
	public void setmcp_currency (String mcp_currency)
	{
		set_Value (COLUMNNAME_mcp_currency, mcp_currency);
	}

	/** Get mcp_currency.
		@return mcp_currency	  */
	public String getmcp_currency()
	{
		return (String)get_Value(COLUMNNAME_mcp_currency);
	}

	/** Set mer_amount.
		@param mer_amount mer_amount
	*/
	public void setmer_amount (BigDecimal mer_amount)
	{
		set_Value (COLUMNNAME_mer_amount, mer_amount);
	}

	/** Get mer_amount.
		@return mer_amount	  */
	public BigDecimal getmer_amount()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_mer_amount);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set merchant_param1.
		@param merchant_param1 merchant_param1
	*/
	public void setmerchant_param1 (String merchant_param1)
	{
		set_Value (COLUMNNAME_merchant_param1, merchant_param1);
	}

	/** Get merchant_param1.
		@return merchant_param1	  */
	public String getmerchant_param1()
	{
		return (String)get_Value(COLUMNNAME_merchant_param1);
	}

	/** Set merchant_param2.
		@param merchant_param2 merchant_param2
	*/
	public void setmerchant_param2 (String merchant_param2)
	{
		set_Value (COLUMNNAME_merchant_param2, merchant_param2);
	}

	/** Get merchant_param2.
		@return merchant_param2	  */
	public String getmerchant_param2()
	{
		return (String)get_Value(COLUMNNAME_merchant_param2);
	}

	/** Set merchant_param3.
		@param merchant_param3 merchant_param3
	*/
	public void setmerchant_param3 (String merchant_param3)
	{
		set_Value (COLUMNNAME_merchant_param3, merchant_param3);
	}

	/** Get merchant_param3.
		@return merchant_param3	  */
	public String getmerchant_param3()
	{
		return (String)get_Value(COLUMNNAME_merchant_param3);
	}

	/** Set merchant_param4.
		@param merchant_param4 merchant_param4
	*/
	public void setmerchant_param4 (String merchant_param4)
	{
		set_Value (COLUMNNAME_merchant_param4, merchant_param4);
	}

	/** Get merchant_param4.
		@return merchant_param4	  */
	public String getmerchant_param4()
	{
		return (String)get_Value(COLUMNNAME_merchant_param4);
	}

	/** Set merchant_param5.
		@param merchant_param5 merchant_param5
	*/
	public void setmerchant_param5 (String merchant_param5)
	{
		set_Value (COLUMNNAME_merchant_param5, merchant_param5);
	}

	/** Get merchant_param5.
		@return merchant_param5	  */
	public String getmerchant_param5()
	{
		return (String)get_Value(COLUMNNAME_merchant_param5);
	}

	/** Set merchant_param6.
		@param merchant_param6 merchant_param6
	*/
	public void setmerchant_param6 (String merchant_param6)
	{
		set_Value (COLUMNNAME_merchant_param6, merchant_param6);
	}

	/** Get merchant_param6.
		@return merchant_param6	  */
	public String getmerchant_param6()
	{
		return (String)get_Value(COLUMNNAME_merchant_param6);
	}

	/** Set offer_code.
		@param offer_code offer_code
	*/
	public void setoffer_code (String offer_code)
	{
		set_Value (COLUMNNAME_offer_code, offer_code);
	}

	/** Get offer_code.
		@return offer_code	  */
	public String getoffer_code()
	{
		return (String)get_Value(COLUMNNAME_offer_code);
	}

	/** Set offer_type.
		@param offer_type offer_type
	*/
	public void setoffer_type (String offer_type)
	{
		set_Value (COLUMNNAME_offer_type, offer_type);
	}

	/** Get offer_type.
		@return offer_type	  */
	public String getoffer_type()
	{
		return (String)get_Value(COLUMNNAME_offer_type);
	}

	/** Set order_status.
		@param order_status order_status
	*/
	public void setorder_status (String order_status)
	{
		set_Value (COLUMNNAME_order_status, order_status);
	}

	/** Get order_status.
		@return order_status	  */
	public String getorder_status()
	{
		return (String)get_Value(COLUMNNAME_order_status);
	}

	/** Set orderid.
		@param orderid orderid
	*/
	public void setorderid (String orderid)
	{
		set_Value (COLUMNNAME_orderid, orderid);
	}

	/** Get orderid.
		@return orderid	  */
	public String getorderid()
	{
		return (String)get_Value(COLUMNNAME_orderid);
	}

	/** Set payment_mode.
		@param payment_mode payment_mode
	*/
	public void setpayment_mode (String payment_mode)
	{
		set_Value (COLUMNNAME_payment_mode, payment_mode);
	}

	/** Get payment_mode.
		@return payment_mode	  */
	public String getpayment_mode()
	{
		return (String)get_Value(COLUMNNAME_payment_mode);
	}

	/** Set si_created.
		@param si_created si_created
	*/
	public void setsi_created (Timestamp si_created)
	{
		set_Value (COLUMNNAME_si_created, si_created);
	}

	/** Get si_created.
		@return si_created	  */
	public Timestamp getsi_created()
	{
		return (Timestamp)get_Value(COLUMNNAME_si_created);
	}

	/** Set si_mer_ref_no.
		@param si_mer_ref_no si_mer_ref_no
	*/
	public void setsi_mer_ref_no (String si_mer_ref_no)
	{
		set_Value (COLUMNNAME_si_mer_ref_no, si_mer_ref_no);
	}

	/** Get si_mer_ref_no.
		@return si_mer_ref_no	  */
	public String getsi_mer_ref_no()
	{
		return (String)get_Value(COLUMNNAME_si_mer_ref_no);
	}

	/** Set si_ref_no.
		@param si_ref_no si_ref_no
	*/
	public void setsi_ref_no (String si_ref_no)
	{
		set_Value (COLUMNNAME_si_ref_no, si_ref_no);
	}

	/** Get si_ref_no.
		@return si_ref_no	  */
	public String getsi_ref_no()
	{
		return (String)get_Value(COLUMNNAME_si_ref_no);
	}

	/** Set si_status.
		@param si_status si_status
	*/
	public void setsi_status (String si_status)
	{
		set_Value (COLUMNNAME_si_status, si_status);
	}

	/** Get si_status.
		@return si_status	  */
	public String getsi_status()
	{
		return (String)get_Value(COLUMNNAME_si_status);
	}

	/** Set status_code.
		@param status_code status_code
	*/
	public void setstatus_code (String status_code)
	{
		set_Value (COLUMNNAME_status_code, status_code);
	}

	/** Get status_code.
		@return status_code	  */
	public String getstatus_code()
	{
		return (String)get_Value(COLUMNNAME_status_code);
	}

	/** Set status_message.
		@param status_message status_message
	*/
	public void setstatus_message (String status_message)
	{
		set_Value (COLUMNNAME_status_message, status_message);
	}

	/** Get status_message.
		@return status_message	  */
	public String getstatus_message()
	{
		return (String)get_Value(COLUMNNAME_status_message);
	}

	/** Set trackingid.
		@param trackingid trackingid
	*/
	public void settrackingid (String trackingid)
	{
		set_Value (COLUMNNAME_trackingid, trackingid);
	}

	/** Get trackingid.
		@return trackingid	  */
	public String gettrackingid()
	{
		return (String)get_Value(COLUMNNAME_trackingid);
	}

	/** Set vault.
		@param vault vault
	*/
	public void setvault (boolean vault)
	{
		set_Value (COLUMNNAME_vault, Boolean.valueOf(vault));
	}

	/** Get vault.
		@return vault	  */
	public boolean isvault()
	{
		Object oo = get_Value(COLUMNNAME_vault);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set visaeppamt.
		@param visaeppamt visaeppamt
	*/
	public void setvisaeppamt (BigDecimal visaeppamt)
	{
		set_Value (COLUMNNAME_visaeppamt, visaeppamt);
	}

	/** Get visaeppamt.
		@return visaeppamt	  */
	public BigDecimal getvisaeppamt()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_visaeppamt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set visaeppfees.
		@param visaeppfees visaeppfees
	*/
	public void setvisaeppfees (BigDecimal visaeppfees)
	{
		set_Value (COLUMNNAME_visaeppfees, visaeppfees);
	}

	/** Get visaeppfees.
		@return visaeppfees	  */
	public BigDecimal getvisaeppfees()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_visaeppfees);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set visaeppfrequency.
		@param visaeppfrequency visaeppfrequency
	*/
	public void setvisaeppfrequency (String visaeppfrequency)
	{
		set_Value (COLUMNNAME_visaeppfrequency, visaeppfrequency);
	}

	/** Get visaeppfrequency.
		@return visaeppfrequency	  */
	public String getvisaeppfrequency()
	{
		return (String)get_Value(COLUMNNAME_visaeppfrequency);
	}

	/** Set visaepprate.
		@param visaepprate visaepprate
	*/
	public void setvisaepprate (BigDecimal visaepprate)
	{
		set_Value (COLUMNNAME_visaepprate, visaepprate);
	}

	/** Get visaepprate.
		@return visaepprate	  */
	public BigDecimal getvisaepprate()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_visaepprate);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set visaepptenure.
		@param visaepptenure visaepptenure
	*/
	public void setvisaepptenure (String visaepptenure)
	{
		set_Value (COLUMNNAME_visaepptenure, visaepptenure);
	}

	/** Get visaepptenure.
		@return visaepptenure	  */
	public String getvisaepptenure()
	{
		return (String)get_Value(COLUMNNAME_visaepptenure);
	}

	/** Set visaeppterms.
		@param visaeppterms visaeppterms
	*/
	public void setvisaeppterms (String visaeppterms)
	{
		set_Value (COLUMNNAME_visaeppterms, visaeppterms);
	}

	/** Get visaeppterms.
		@return visaeppterms	  */
	public String getvisaeppterms()
	{
		return (String)get_Value(COLUMNNAME_visaeppterms);
	}

	/** Set visaplanacceptanceid.
		@param visaplanacceptanceid visaplanacceptanceid
	*/
	public void setvisaplanacceptanceid (String visaplanacceptanceid)
	{
		set_Value (COLUMNNAME_visaplanacceptanceid, visaplanacceptanceid);
	}

	/** Get visaplanacceptanceid.
		@return visaplanacceptanceid	  */
	public String getvisaplanacceptanceid()
	{
		return (String)get_Value(COLUMNNAME_visaplanacceptanceid);
	}

	/** Set visaplanid.
		@param visaplanid visaplanid
	*/
	public void setvisaplanid (String visaplanid)
	{
		set_Value (COLUMNNAME_visaplanid, visaplanid);
	}

	/** Get visaplanid.
		@return visaplanid	  */
	public String getvisaplanid()
	{
		return (String)get_Value(COLUMNNAME_visaplanid);
	}
}