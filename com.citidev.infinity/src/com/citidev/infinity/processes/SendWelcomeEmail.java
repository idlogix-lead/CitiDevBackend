package com.citidev.infinity.processes;

import java.util.regex.Pattern;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MClient;
import org.compiere.model.MProcessPara;
import org.compiere.model.MUser;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.CLogger;
import org.compiere.util.EMail;

@org.adempiere.base.annotation.Process
public class SendWelcomeEmail extends SvrProcess {

    private static final CLogger log = CLogger.getCLogger(SendWelcomeEmail.class);

    private int userId;
    private String email;
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
        );
    
    
    @Override
    protected void prepare() {
        for (ProcessInfoParameter param : getParameter()) {
            String name = param.getParameterName();
            if ("AD_User_ID".equalsIgnoreCase(name)) {
                userId = param.getParameterAsInt();
            }
            else if ("Email".equalsIgnoreCase(name)) {
                email = param.getParameterAsString();
            }
            else {
                MProcessPara.validateUnknownParameter(getProcessInfo().getAD_Process_ID(), param);
            }
        }
    }

    @Override
    protected String doIt() throws Exception {
        if (userId <= 0 ) {
        	throw new AdempiereException("Invalid parameters: User ID is missing.");
        }

        
        MUser user = new MUser(getCtx(), userId, get_TrxName());
        MClient client = new MClient(getCtx(), user.getAD_Client_ID(), get_TrxName());

        String fromEmail = client.getRequestEMail();
        String toEmail = (email ==null || email.isEmpty()) ? user.getEMail() : email;

        if (!isValidEmail(fromEmail) || !isValidEmail(toEmail)) {
        	throw new AdempiereException("Invalid sender or recipient email address.");
        }
        
        sendEmail(client, fromEmail, toEmail, user);
        
        return "Mail sent successfully.";
    } 
    
    private void sendEmail(MClient client, String from, String to,MUser user) {
    	
    	String fullName = user.get_ValueAsString("FullName");
    	String username = fullName==null || fullName.isEmpty() ? user.getName() : fullName;
        String subject = "Welcome Onboard!";
        String message = getWelcomeEmailHtml(username);

        EMail email = new EMail(client, from, to, subject, message);
        email.setMessageHTML(message);
        String error = email.send();

        if (error != null && !error.isEmpty() && !error.equals("OK")) {
            throw new RuntimeException("Failed to send email: " + error);
        }
    }
    
    public static String getWelcomeEmailHtml(String userName) {
        return """
            <!DOCTYPE html>
            <html lang="en" style="margin: 0; padding: 0">
              <head>
                <meta charset="UTF-8" />
                <meta name="viewport" content="width=device-width, initial-scale=1.0" />
                <title>Welcome to Our App</title>
                <style>
                  body {
                    margin: 0;
                    padding: 0;
                    font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
                    background-color: #f6f9fc;
                    color: #333;
                  }
                  .container {
                    max-width: 600px;
                    margin: 30px auto;
                    background: #ffffff;
                    border-radius: 12px;
                    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.08);
                    overflow: hidden;
                  }
                  .header {
                    background-color: #4f46e5;
                    color: #ffffff;
                    text-align: center;
                    padding: 30px 20px;
                  }
                  .header h1 {
                    margin: 0;
                    font-size: 26px;
                  }
                  .content {
                    padding: 30px 25px;
                    line-height: 1.6;
                    font-size: 16px;
                  }
                  .content h2 {
                    color: #111827;
                  }
                  .button {
                    display: inline-block;
                    background-color: #4f46e5;
                    color: #ffffff !important;
                    padding: 12px 24px;
                    border-radius: 6px;
                    text-decoration: none;
                    font-weight: 600;
                    margin-top: 20px;
                  }
                  .footer {
                    text-align: center;
                    font-size: 13px;
                    color: #888;
                    padding: 20px;
                  }
                </style>
              </head>
              <body>
                <div class="container">
                  <div class="header">
                    <h1>Welcome to CitiDev SuperApp!</h1>
                  </div>
                  <div class="content">
                    <h2>Hey {{UserName}},</h2>
                    <p>We’re excited to have you join our community! 🎉</p>
                    <p>
                      With <strong>CitiDev SuperApp</strong>, you can easily manage your
                      properties, explore features, and enjoy a seamless experience.
                    </p>
                    <p style="margin-top: 25px">
                      If you have any questions, just reply to this email — we’re always
                      happy to help.
                    </p>
                    <p>Cheers,<br />The CitiDev Team</p>
                  </div>
                  <div class="footer">© CitiDev SuperApp. All rights reserved.<br /></div>
                </div>
              </body>
            </html>
            """.replace("{{UserName}}", userName);
    }

    private boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }
}
