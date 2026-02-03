package com.citidev.ccavenue.processes;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

import org.adempiere.base.annotation.Process;
import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MProcessPara;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;

import com.ccavenue.util.AesCryptUtil;
import com.citidev.models.MCCAvenueConf;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

@Process
public class CCAvenueApplePayTransaction extends SvrProcess {

    private String pAppleTokenJson;
    private String pC_Invoice_ID;

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void prepare() {
        for (ProcessInfoParameter param : getParameter()) {
            String name = param.getParameterName();

            if ("AppleToken".equalsIgnoreCase(name))
                pAppleTokenJson = param.getParameterAsString();
            else if ("InvoiceIDs".equalsIgnoreCase(name))
                pC_Invoice_ID = param.getParameterAsString();
            else
                MProcessPara.validateUnknownParameter(getProcessInfo().getAD_Process_ID(), param);
        }
    }

    @Override
    protected String doIt() throws Exception {

        if (pAppleTokenJson == null || pAppleTokenJson.isEmpty())
            throw new AdempiereException("Apple Token is missing");

        try {
            // 🔹 Validate JSON using Jackson (no modification)
            JsonNode tokenNode = mapper.readTree(pAppleTokenJson);
            log.info("Apple Pay token received. TransactionIdentifier=" +
                    tokenNode.path("transactionIdentifier").asText());

            // 🔹 Load CCAvenue Config
            MCCAvenueConf conf = new Query(getCtx(), MCCAvenueConf.Table_Name, "", get_TrxName())
                    .setClient_ID()
                    .setOnlyActiveRecords(true)
                    .first();

            if (conf == null || conf.get_ID() <= 0)
                throw new AdempiereException("CCAvenue configuration missing");

            String workingKey = conf.getworkingkey();
            String accessCode = conf.getaccesscode();
            String merchantId = conf.getmerchantid();
            String appleMerchantId = "merchant.com.citideveloper.superapp.ccavenue";
            String redirectUrl = "http://infinitycitidev.duckdns.org:8080/payment/ccavenuecallback";

            // 🔹 STEP 1 — URL Encode Apple Token
            String encodedAppleToken = URLEncoder.encode(pAppleTokenJson, StandardCharsets.UTF_8.toString());

            // 🔹 STEP 2 — Build parameter map
            Map<String, String> params = new LinkedHashMap<>();
            params.put("merchant_id", merchantId);
            params.put("order_id", String.valueOf(System.currentTimeMillis())); // temp order ref
            params.put("currency", "AED");
            params.put("amount", "1.00"); // placeholder for now
            params.put("redirect_url", redirectUrl);

            // Apple Pay specific
            params.put("payment_option", "OPTAPLPY");
            params.put("card_type", "APLPY");
            params.put("card_name", "Apple pay");
            params.put("applePayMerchantId", appleMerchantId);
            params.put("applePaySeamlessFlag", "Y");
            params.put("applePayEncDATA", encodedAppleToken);

            // 🔹 STEP 3 — Convert to query string
            StringBuilder requestData = new StringBuilder();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                requestData.append(entry.getKey())
                           .append("=")
                           .append(entry.getValue())
                           .append("&");
            }
            requestData.deleteCharAt(requestData.length() - 1);

            // 🔹 STEP 4 — Encrypt
            AesCryptUtil aes = new AesCryptUtil(workingKey);
            String encRequest = aes.encrypt(requestData.toString());

            // 🔹 STEP 5 — Call CCAvenue using Apache HttpClient
            String url = "https://secure.ccavenue.ae/transaction/transaction.do?command=initiatePayloadTransaction";

            try (CloseableHttpClient client = HttpClients.createDefault()) {

                HttpPost post = new HttpPost(url);
                String body = "encRequest=" + encRequest + "&access_code=" + accessCode;

                post.setEntity(new StringEntity(body));
                post.setHeader("Content-Type", "application/x-www-form-urlencoded");

                try (CloseableHttpResponse response = client.execute(post)) {
                    String pgResponse = new String(response.getEntity().getContent().readAllBytes(),
                            StandardCharsets.UTF_8);

                    log.info("CCAvenue Raw Response: " + pgResponse);
                    return pgResponse;
                }
            }

        } catch (Exception e) {
            throw new AdempiereException("Apple Pay transaction failed: " + e.getMessage(), e);
        }
    }
}
