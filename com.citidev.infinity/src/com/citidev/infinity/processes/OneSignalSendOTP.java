package com.citidev.infinity.processes;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Random;
import java.util.regex.Pattern;

import org.adempiere.exceptions.AdempiereException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.compiere.model.MProcessPara;
import org.compiere.model.MUser;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.Env;

import com.citidev.models.MCDMFA;
import com.citidev.models.MOneSignalConf;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@org.adempiere.base.annotation.Process
public class OneSignalSendOTP extends SvrProcess {

    private int userId;
    private int clientId;
    private String email;

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
    );

    private static final int OTP_EXPIRY_MINUTES = 5;

    @Override
    protected void prepare() {
        for (ProcessInfoParameter param : getParameter()) {
            String name = param.getParameterName();
            if ("AD_Client_ID".equalsIgnoreCase(name)) {
                clientId = param.getParameterAsInt();
            } else if ("AD_User_ID".equalsIgnoreCase(name)) {
                userId = param.getParameterAsInt();
            } else if ("Email".equalsIgnoreCase(name)) {
                email = param.getParameterAsString();
            } else {
                MProcessPara.validateUnknownParameter(
                        getProcessInfo().getAD_Process_ID(), param);
            }
        }
    }

    @Override
    protected String doIt() throws Exception {

        if (userId <= 0 || clientId <= 0) {
            return "Invalid parameters: Client or User not specified.";
        }

        MUser user = new MUser(getCtx(), userId, get_TrxName());
        String toEmail = (email == null || email.isEmpty())
                ? user.getEMail()
                : email;

        if (!isValidEmail(toEmail)) {
            throw new AdempiereException("Invalid sender or recipient email address.");
        }

        String filter = MOneSignalConf.COLUMNNAME_AD_Client_ID + " = ? AND "
                + MOneSignalConf.COLUMNNAME_AD_Org_ID + " = ?";

        MOneSignalConf conf = new Query(
                getCtx(),
                MOneSignalConf.Table_Name,
                filter,
                get_TrxName())
                .setParameters(clientId, Env.getAD_Org_ID(getCtx()))
                .first();

        if (conf == null || conf.get_ID() <= 0) {
            throw new AdempiereException(
                    "One Signal Conf Missing for this client and this org!");
        }

        String appId = conf.getonesignal_appid();
        String apiKey = conf.getonesignal_email_api_key();

        String otp = generateOTP();
        String subject = "Your Verification Code";
        String body = "Your OTP code is " + otp + ". It is valid for 5 minutes";

        saveOTPRecord(userId, toEmail, otp);
        sendEmail(apiKey, appId, toEmail, subject, body);

        return "OTP sent successfully to " + toEmail;
    }

    
    private String generateOTP() {
        return String.format("%06d", new Random().nextInt(1_000_000));
    }

    
    private void saveOTPRecord(int userId, String toemail, String otp) {
        MCDMFA record = new MCDMFA(getCtx(), 0, get_TrxName());
        record.setAD_User_ID(userId);
        record.setotp(otp);
        record.setEMail(toemail);
        record.setvaliduntil(new Timestamp(
                System.currentTimeMillis() + OTP_EXPIRY_MINUTES * 60 * 1000));
        record.setIsVerified(false);
        record.saveEx();
    }

    
    private void sendEmail(String apiKey, String appId, String to,
                           String subject, String body) throws IOException {

        String url = "https://onesignal.com/api/v1/notifications";

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);

        post.addHeader("Authorization", "Basic " + apiKey);
        post.addHeader("Content-Type", "application/json");

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode root = mapper.createObjectNode();

        root.put("app_id", appId);

        ArrayNode emailTokens = root.putArray("include_email_tokens");
        emailTokens.add(to);

        root.put("email_subject", subject);
        root.put("email_body", body);

        String json = mapper.writeValueAsString(root);
        post.setEntity(new StringEntity(json, "UTF-8"));

        CloseableHttpResponse response = client.execute(post);
        String result = EntityUtils.toString(response.getEntity(), "UTF-8");
        int status = response.getStatusLine().getStatusCode();

        response.close();
        client.close();

        if (status < 200 || status >= 300) {
            throw new RuntimeException(
                    "OneSignal API error (HTTP " + status + "): " + result);
        }
    }

    private boolean isValidEmail(String email) {
        return email != null
                && !email.isBlank()
                && EMAIL_PATTERN.matcher(email).matches();
    }
}
