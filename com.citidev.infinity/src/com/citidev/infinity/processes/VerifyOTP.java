package com.citidev.infinity.processes;

import java.sql.Timestamp;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MProcessPara;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import com.citidev.models.MCDMFA;

@org.adempiere.base.annotation.Process
public class VerifyOTP extends SvrProcess {

    private static final CLogger log = CLogger.getCLogger(VerifyOTP.class);

    private int userId;
    private String otp;

    @Override
    protected void prepare() {
        for (ProcessInfoParameter param : getParameter()) {
            String name = param.getParameterName();
            if ("AD_User_ID".equals(name)) {
                userId = param.getParameterAsInt();
            } else if ("OTP".equals(name)) {
                otp = (String) param.getParameter();
            } else {
                MProcessPara.validateUnknownParameter(getProcessInfo().getAD_Process_ID(), param);
            }
        }
    }

    @Override
    protected String doIt() throws Exception {
        if (userId <= 0 || otp == null || otp.trim().isEmpty()) {
        	throw new AdempiereException("Invalid parameters: User ID or OTP is missing.");
        }

        MCDMFA record = getLatestActiveOTP(userId);
        if (record == null) {
        	throw new AdempiereException("No active OTP found or OTP expired.");
        }

        // Verify OTP match
        if (!otp.equals(record.getotp())) {
            incrementAttemptCount(record);
            throw new AdempiereException("Invalid OTP!");
        }

        // Check if OTP is expired
        Timestamp now = new Timestamp(System.currentTimeMillis());
        if (record.getvaliduntil().before(now)) {
            markAsExpired(record);
            throw new AdempiereException("OTP has expired.");
        }

        // Mark success
        record.setIsVerified(true);
        record.setConsumed(true);
        record.saveEx();

        return "OTP verified successfully.";
    }

    /** Fetch latest unverified & active OTP record for the user */
    private MCDMFA getLatestActiveOTP(int userId) {
        String whereClause = "AD_User_ID=? AND IsVerified='N' AND consumed='N' "
                           + "AND validuntil >= ?";
        return new Query(Env.getCtx(), MCDMFA.Table_Name, whereClause, get_TrxName())
                .setParameters(userId, new Timestamp(System.currentTimeMillis()))
                .setOrderBy("Created DESC")
                .first();
    }

    /** Increment attempt count to prevent brute force */
    private void incrementAttemptCount(MCDMFA record) {
        int attempts = record.getattemptcount() + 1;
        record.setattemptcount(attempts);
        if (attempts >= 5) {
            record.setConsumed(true);
            log.warning("Too many failed OTP attempts for user " + userId);
        }
        record.saveEx();
    }

    /** Mark record as expired */
    private void markAsExpired(MCDMFA record) {
        record.setConsumed(true);
        record.saveEx();
    }
}
