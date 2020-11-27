package com.ludynia.pizza.twilio;

import com.twilio.Twilio;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TwilioInit {

    private TwilloConfig twilloConfig;

    public TwilioInit(TwilloConfig twilloConfig) {
        this.twilloConfig = twilloConfig;
        Twilio.init(twilloConfig.getAccountSid(),twilloConfig.getAuthToken());
    }




}
