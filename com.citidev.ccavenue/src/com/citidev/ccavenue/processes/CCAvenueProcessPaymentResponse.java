package com.citidev.ccavenue.processes;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MProcessPara;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.json.JSONObject;

import com.ccavenue.util.AesCryptUtil;
import com.citidev.models.MCCAvenuPaymentResponse;
import com.citidev.models.MCCAvenueConf;

@org.adempiere.base.annotation.Process
public class CCAvenueProcessPaymentResponse extends SvrProcess {

    private String pEncResp;
    private String pOrderNo;

    @Override
    protected void prepare() {
    	
    	 for (ProcessInfoParameter param : getParameter()) {
             String name = param.getParameterName();
             if ("EncResp".equalsIgnoreCase(name)) {
            	 pEncResp = param.getParameterAsString();
             } else if ("OrderNo".equalsIgnoreCase(name)) {
            	 pOrderNo = param.getParameterAsString();
             }
             else {
                 MProcessPara.validateUnknownParameter(getProcessInfo().getAD_Process_ID(), param);
             }
         }
    	     
    }

    @Override
    protected String doIt() throws Exception {
    	
//    	pEncResp = pEncResp.trim();
//    	pOrderNo = pOrderNo.trim();
//
//    	if(pEncResp == null || pOrderNo == null || pEncResp.isEmpty() || pOrderNo.isEmpty()) {
//    		throw new AdempiereException("Missing EncResponse / OrderNo");
//    	}
    	
    	pEncResp = "699e5c2ee32415ab4f2b8534ca88d94b261841be717f808465b54552ddf42aed0699114adedecf5ff553f28b2cdbc783b5ed16baaefb5927868aebb679c23c8599f8d6a3078f15e47bba4c42f07c92860fe88ca037f940ea25ee207865d3bb5f27f21e36b98bb046aa41441ab59c0ab4ec10cf7a2617366798e56cb98b52056a2356e9fff01b46ebd8052fd41ba0375a9200589ffa394ac1ce6125ea9797bc2759f4c7587c9fd004cb9384d87c0ab33141aaea868646c3b473e6993505b8698170d56ed2e08f0d92466bd859474d6c930d291f9b1241008a0e72a72743f7df1ed76288dc6b47e9077ae2033a9b6563ebbe650deb4d7cabfe4b1e5c8185ad796042d8cad290b0e9d56a9357f7ef5b4b9f8c1ba505777e8c54801239236b6d81422cca911716d35676c8582ffedcafca08c435fdd29bdb7ca06698c87cfcd442ecd8d6ee0388020c1d7ec767bf533ad7ef38ac35536e0600d69ff5bc501d81259db4d3e3ecb30f039918ddcb3868ce4e69223af4a3a70d3a43650635f61658c7291fe3f8a901f601884a9eb575113ec6c324c1bd64d45a2a49e8b8d27053fafe215427524104b35c1020e023ed26f0384c77619a7850e228788f356886b4a9fb22b208a76ef9fe1b264e7c95b20f07a16550ae5560a4338a9d747d8c655b67566c0e43b188160d07d7bff3f7e03b323e8141fa75379681a1bf0cbdddf08669c9d4ec34b81984419d3827d0978c5defcb7bc51e7696e21c22bf98d028603252681c58e157b70872809bbcde526fe0dbfb181ff2540704309dfe9a4e6f942b409448ff77e2193c80db47946302577b1717ed5c42223cd4fd0eb9cf4c77bb6a195f2aadbde429a7c8c48444d9f6bea7a58aadb7b00505c7cbc6b266a8835aeed955402bd245725d9989e3dbd2db5a7b0157ccce31bcb6d59e3f85f520abf807c2a409f5ae6a03624cfa3b9ad80f263369d00cba262363e1d9f0d3c6ca0f5779fe9041891d83c512f5c7de28d6ae5e5d6216beeb1346775b5c9c5fbeb4b77d744f2cacf0b93dcb94050f99ccae860f9909a36630d86374d83f8f5b2929b6212a47f1586427bdd0fe90808c38adecc3f9810c47c67fc4d4cb05ceadd99bcfdb88a44359731cf41e5e3074e5877f0afafc21e6048475abe5db808ea19b7787926e4ea1fc3af539fd375592b2f276a0c4fc652700ca9a84c27f9327bb3736797912c82529d3970cf2bbfdc20eb785a665b927b19ceb3c6de7fa7e0592fa11db52ce45e8d4468976dc78300ca8454b75da5cfb4d52436d17a5df77ecb559b8d0c9d79bdec6d6cc096e99bf3386d78f8e27161fac42970cf2ffdea6468e03acc296c92ba8f550de031bda04e395245aa59e02b83478a623983fa9a5e28e492a6b6d0edd5f64109c8290bf1f0df9cbca86b5940327c0d179a3032cd24449a02a7f4f31416c3b08367f6db26234235aa0d82b853b09a33bce59c2107e84ee6e8dfe42ea2824e462630688805ff9ac629d4cecf0c586ecd9b5d59b9ab87a8036f8a6bf301832afb880ec6554e706b6f8a483084b524e3faf066856830b207ae4985d4c57ce177c392c7fb0ebaad3bb977916813e353494703d69807c1cafc34ef2728d6ea8f88548baa135af5aa88cbb752c3008dba2d453d481982ee2d13ba96df16a1f49625d7da8260b99c28247087b8e8af354d4ced30b85f4be0a02b272fc0edc73c0268a1b0b1f90da644b5df181c2f9b8c0b3c42298bd5e6b1b03ab31a50d96de68a5a5071c6ba2534142a7e1be77fea8bcc8529b4387a25c7dc99f4fec719a23a84e5164fb9948c9878e306986020105cbb4cf59e9774b05dc8ab08c229fc733baf304ea678d787837e67e995fd87a08cc92ff5c3e074f13d6378c2276f7be8e9484497bd0543a0bdd5d0ba30c0afee194a74587fba18305872247df5a9c474dee32d0bce2394500c2aa1f3ca5a87afc747259a928e2aff83f6ab1f442d208148f80aa";
    	pOrderNo = "2968962";
    	
    	MCCAvenueConf ccaconf = new Query(getCtx(),MCCAvenueConf.Table_Name, "", get_TrxName())
    			.setClient_ID()
    			.setOnlyActiveRecords(true)
    			.first();
    	
    	if(ccaconf==null || ccaconf.get_ID()<=0)
    		throw new AdempiereException("No CcAvenue Configuration found!");

        String workingKey = ccaconf.getworkingkey();
        
        AesCryptUtil aes = new AesCryptUtil(workingKey);
        String decryptedResponse = aes.decrypt(pEncResp);
        saveRawPaymentResponse(decryptedResponse);
        
    	
    	
    	

    	return null;
    }
    

    public void saveRawPaymentResponse(String decryptedResponse) {

        if (decryptedResponse == null || decryptedResponse.isEmpty()) {
            throw new IllegalArgumentException("Decrypted response is empty");
        }

        JSONObject json = new JSONObject(decryptedResponse);

        MCCAvenuPaymentResponse model = new MCCAvenuPaymentResponse(getCtx(),0, get_TrxName());

        model.setmerchant_param6(json.optString("merchant_param6", null));
        model.setvisaplanacceptanceid(json.optString("visaPlanAcceptanceId", null));
        model.setmerchant_param5(json.optString("merchant_param5", null));
        model.setmerchant_param4(json.optString("merchant_param4", null));
        model.setmerchant_param3(json.optString("merchant_param3", null));
        model.setbilling_name(json.optString("billing_name", null));
        model.setmerchant_param2(json.optString("merchant_param2", null));
        model.setstatus_message(json.optString("status_message", null));
        model.setsi_status(json.optString("si_status", null));
        model.setmerchant_param1(json.optString("merchant_param1", null));
        model.setvisaeppamt(parseDecimal((json.optString("visaEppAmt", ""))));
        model.setbilling_city(json.optString("billing_city", null));
        model.setcustomer_cardid(json.optString("customer_card_id", null));
        model.setvisaeppfees(parseDecimal(json.optString("visaEppFees", "")));
        model.setvisaepptenure(json.optString("visaEppTenure", null));
        model.setorder_status(json.optString("order_status", null));
        model.setbilling_country(json.optString("billing_country", null));
        model.setis_mcp_txn(parseBoolean(json.optString("is_mcp_txn", null)));
        model.setissuer(json.optString("issuer", null));
        model.setvisaeppfrequency(json.optString("visaEppFrequency", null));
        model.setbilling_address(json.optString("billing_address", null));
        model.setbank_qsi_no(json.optString("bank_qsi_no", null));
        model.setbilling_notes(json.optString("billing_notes", null));
        model.setdiscount_value(parseDecimal(json.optString("discount_value", "")));
        model.setbilling_zip(json.optString("billing_zip", null));
        model.setdelivery_country(json.optString("delivery_country", null));
        model.setbilling_tel(json.optString("billing_tel", null));
        model.setfailure_message(json.optString("failure_message", null));
        model.setvisaplanid(json.optString("visaPlanId", null));
        model.setorderid(json.optString("order_id", null));
        model.setbank_ref_no(json.optString("bank_ref_no", null));
        model.setdelivery_address(json.optString("delivery_address", null));
        model.setstatus_code(json.optString("status_code", null));
        model.setsi_ref_no(json.optString("si_ref_no", null));
        model.setbilling_state(json.optString("billing_state", null));
        model.setsi_mer_ref_no(json.optString("si_mer_ref_no", null));
        model.setmcp_currency(json.optString("mcp_currency", null));
        model.setpayment_mode(json.optString("payment_mode", null));
        model.setvault(parseBoolean(json.optString("vault", null)));
        model.setdelivery_state(json.optString("delivery_state", null));
        model.setcard_holder_name(json.optString("card_holder_name", null));
        model.setoffer_type(json.optString("offer_type", null));
        model.setvisaeppterms(json.optString("visaEppTerms", null));
        model.setinv_mer_reference_no(json.optString("inv_mer_reference_no", null));
        model.setdelivery_name(json.optString("delivery_name", null));
        model.setoffer_code(json.optString("offer_code", null));
        model.setbank_receipt_no(json.optString("bank_receipt_no", null));
        model.settrackingid(json.optString("tracking_id", null));
        model.setmcp_conversion_rate(parseDecimal(json.optString("mcp_conversion_rate", "")));
        model.setdelivery_city(json.optString("delivery_city", null));
        model.setvisaepprate(parseDecimal(json.optString("visaEppRate", "")));
        model.setacquirer_message(json.optString("acquirer_message", null));
        model.setdelivery_zip(json.optString("delivery_zip", null));
        model.setdelivery_tel(json.optString("delivery_tel", null));
        model.setCurrency(json.optString("currency", null));
        model.setsi_created(parseTimestamp(json.optString("si_created", null)));
        model.seteci_value(json.optString("eci_value", null));
        model.setcard_name(json.optString("card_name", null));
        model.setmcp_amount(parseDecimal(json.optString("mcp_amount", "")));
        model.setbilling_email(json.optString("billing_email", null));
        model.setAmount(parseDecimal(json.optString("amount", null)));
        model.setmer_amount(parseDecimal(json.optString("mer_amount", null)));
        model.save();

    }

    private BigDecimal parseDecimal(String value) {
        if (value == null || value.isEmpty()) return null;
        try {
            return new BigDecimal(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private Boolean parseBoolean(String value) {
        if (value == null || value.isEmpty()) return null;
        value = value.trim().toUpperCase();
        switch (value) {
            case "Y":
                return Boolean.TRUE;
            case "N":
                return Boolean.FALSE;
            default:
                return null; 
        }
    }
    
    private Timestamp parseTimestamp(String value) {
        if (value == null || value.isEmpty()) return null;

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime ldt = LocalDateTime.parse(value, formatter);
            return Timestamp.valueOf(ldt);
        } catch (Exception e) {
            // fallback or log error
            e.printStackTrace();
            return null;
        }
    }

}


