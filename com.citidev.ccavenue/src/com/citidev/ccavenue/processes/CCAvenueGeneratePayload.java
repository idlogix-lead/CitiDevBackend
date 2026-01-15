package com.citidev.ccavenue.processes;

import java.net.URLEncoder;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MProcessPara;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.json.JSONObject;

import com.ccavenue.util.AesCryptUtil;
import com.ccavenue.util.SdkUtil;
import com.citidev.models.MCCAvenueConf;

@org.adempiere.base.annotation.Process
public class CCAvenueGeneratePayload extends SvrProcess {

    private String pAmount;
    private String pCurrency;
    private String pOrderId;
    private String pCustomerName;
    private String pCustomerEmail;

    @Override
    protected void prepare() {
    	
    	 for (ProcessInfoParameter param : getParameter()) {
             String name = param.getParameterName();
             if ("Order_ID".equalsIgnoreCase(name)) {
            	 pOrderId = param.getParameterAsString();
             } else if ("Amount".equalsIgnoreCase(name)) {
            	 pAmount = param.getParameterAsString();
             } else if ("Currency".equalsIgnoreCase(name)) {
        		 pCurrency = param.getParameterAsString();
             } else if ("CustomerName".equalsIgnoreCase(name)) {
            	 pCustomerName = param.getParameterAsString();
             } else if ("CustomerEmail".equalsIgnoreCase(name)) {
            	 pCustomerEmail = param.getParameterAsString();
             }
             else {
                 MProcessPara.validateUnknownParameter(getProcessInfo().getAD_Process_ID(), param);
             }
         }
    	 
//         Example params 
//        pAmount = "500.0";
//        pCurrency = "AED";
//        pOrderId = "901688932";
//        pCustomerName = "CitiDev";
//        pCustomerEmail = "citidev@citidev.com";
             
    }

    @Override
    protected String doIt() throws Exception {

    	try {
    		MCCAvenueConf ccaconf = new Query(getCtx(),MCCAvenueConf.Table_Name, "", get_TrxName())
        			.setClient_ID()
        			.setOnlyActiveRecords(true)
        			.first();
        	
        	if(ccaconf==null || ccaconf.get_ID()<=0)
        		throw new AdempiereException("No CcAvenue Configuration found!");

        	String accessCode = ccaconf.getaccesscode();
            String workingKey = ccaconf.getworkingkey();
            String merchantId = ccaconf.getmerchantid();
            String url = ccaconf.getURL();
            
            //Build the JSON object with order params
            JSONObject requestParam = new JSONObject();
            requestParam.put("merchant_id", merchantId);
            requestParam.put("order_id", URLEncoder.encode(pOrderId, "UTF-8"));
            requestParam.put("currency", URLEncoder.encode(pCurrency != null ? pCurrency : "AED", "UTF-8"));
            requestParam.put("amount", Double.parseDouble(pAmount));
            
            
            if (pCustomerName != null)
                requestParam.put("customer_name", URLEncoder.encode(pCustomerName, "UTF-8"));
            if (pCustomerEmail != null)
                requestParam.put("customer_email", URLEncoder.encode(pCustomerEmail, "UTF-8"));

            //Encrypt the payload
            AesCryptUtil aesCryptUtil = new AesCryptUtil(workingKey);
            String encRequest = aesCryptUtil.encrypt(requestParam.toString());

            //Prepare the request JSON for tracking ID API
            JSONObject trackingIdGenReq = new JSONObject();
            trackingIdGenReq.put("access_code", accessCode);
            trackingIdGenReq.put("encRequest", encRequest);

            //Send to CCAvenue tracking ID endpoint
            SdkUtil sdkUtil = new SdkUtil();
            String trackingIdResp = sdkUtil.processUrlConnectionReq(trackingIdGenReq.toString(), url);

            //Parse response
            JSONObject trackingIdJsonResp = new JSONObject(trackingIdResp);
            JSONObject sdkResponse = new JSONObject();
            sdkResponse.put("status", trackingIdJsonResp.optString("status"));
            sdkResponse.put("message", trackingIdJsonResp.optString("message"));
            sdkResponse.put("encRequest", encRequest);

            if ("success".equalsIgnoreCase(trackingIdJsonResp.optString("status"))) {
                JSONObject trackingIdEncRespData = trackingIdJsonResp.optJSONObject("data");
                if (trackingIdEncRespData != null) {
                    String trackingEncryptedIdDetails = trackingIdEncRespData.optString("encResp");
                    String trackingDecryptedIdDetails = aesCryptUtil.decrypt(trackingEncryptedIdDetails);

                    JSONObject orderDetails = new JSONObject(trackingDecryptedIdDetails);
                    String trackingId = orderDetails.optString("tracking_id");

                    //Generate request hash using SDK
                    String requestHash = SdkUtil.generateHash(
                            trackingId +
                            orderDetails.optString("currency") +
                            orderDetails.optString("amount") +
                            workingKey
                    );
                    orderDetails.put("requestHash", requestHash);
                    sdkResponse.put("data", orderDetails);
                }
            }

            String finalResponse = sdkResponse.toString();
            log.info("Tracking Id Generation Response :: " + finalResponse);
            return finalResponse;
            
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
    }

}

