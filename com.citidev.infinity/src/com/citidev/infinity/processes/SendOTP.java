package com.citidev.infinity.processes;

import java.sql.Timestamp;
import java.util.Random;
import java.util.regex.Pattern;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MClient;
import org.compiere.model.MProcessPara;
import org.compiere.model.MUser;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.EMail;
import com.citidev.models.MCDMFA;

@org.adempiere.base.annotation.Process
public class SendOTP extends SvrProcess {

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
            }
            else {
                MProcessPara.validateUnknownParameter(getProcessInfo().getAD_Process_ID(), param);
            }
        }
    }

    @Override
    protected String doIt() throws Exception {
        if (userId <= 0 || clientId <= 0) {
            return "Invalid parameters: Client or User not specified.";
        }

        MUser user = new MUser(getCtx(), userId, get_TrxName());
        MClient client = new MClient(getCtx(), clientId, get_TrxName());

        String fromEmail = client.getRequestEMail();
        String toEmail = (email ==null || email.isEmpty()) ? user.getEMail() : email;

        if (!isValidEmail(fromEmail) || !isValidEmail(toEmail)) {
        	throw new AdempiereException("Invalid sender or recipient email address.");
        }

        String otp = generateOTP();

        saveOTPRecord(userId, toEmail ,otp);
        sendEmail(client, fromEmail, toEmail, otp);
        
        return "OTP sent successfully to " + toEmail;
    }

    /** Generate a 6-digit OTP */
    private String generateOTP() {
        return String.format("%06d", new Random().nextInt(1_000_000));
    }

    /** Store OTP record */
    private void saveOTPRecord(int userId, String toemail, String otp) {
        MCDMFA record = new MCDMFA(getCtx(), 0, get_TrxName());
        record.setAD_User_ID(userId);
        record.setotp(otp);
        record.setEMail(toemail);
        record.setvaliduntil(new Timestamp(System.currentTimeMillis() + OTP_EXPIRY_MINUTES * 60 * 1000));
        record.setIsVerified(false);
        record.saveEx();
    }

    /** Send OTP email */
    private void sendEmail(MClient client, String from, String to, String otp) {
        String subject = "Your Verification Code";
        String message = String.format("Your OTP code is %s. It is valid for %d minutes.", otp, OTP_EXPIRY_MINUTES);

        EMail email = new EMail(client, from, to, subject, message);
        String error = email.send();

        if (error != null && !error.isEmpty() && !error.equals("OK")) {
            throw new RuntimeException("Failed to send email: " + error);
        }
    }

    /** Validate email format */
    private boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }
}
