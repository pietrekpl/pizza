package com.ludynia.pizza.twilio;

import com.twilio.Twilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TwilioInit {

    private final TwilioConfig twilloConfig;

    private final static Logger LOGGER = LoggerFactory.getLogger(TwilioInit.class);
    @Autowired
    public TwilioInit(TwilioConfig twilloConfig) {
        this.twilloConfig = twilloConfig;
        LOGGER.info(twilloConfig.getAccountSid());
        LOGGER.info(twilloConfig.getAuthToken());
        LOGGER.info(twilloConfig.getTrialNumber());
        Twilio.init(twilloConfig.getAccountSid(),twilloConfig.getAuthToken());
    }




}
