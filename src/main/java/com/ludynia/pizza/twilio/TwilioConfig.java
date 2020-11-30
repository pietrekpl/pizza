package com.ludynia.pizza.twilio;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;



@Configuration
@ConfigurationProperties("twilio")
public class TwilioConfig {


    private final static String ACCOUNT_SID = "sid";
    private final static String AUTH_ID = "auth_token";
    private final static String PHONE_NUMBER = "phone_number";

    private String accountSid;
    private String authToken;
    private String trialNumber;

    public TwilioConfig() {
    }

    public String getAccountSid() {
        return ACCOUNT_SID;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public String getAuthToken() {
        return AUTH_ID;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getTrialNumber() {
        return PHONE_NUMBER;
    }

    public void setTrialNumber(String trialNumber) {
        this.trialNumber = trialNumber;
    }
}
