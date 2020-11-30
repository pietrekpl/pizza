package com.ludynia.pizza.twilio;


import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

@Service("twilio")
public class TwilioSmsSender implements MessageSender {

    private final TwilioConfig twilioConfig;

    public TwilioSmsSender(TwilioConfig twilioConfig) {
        this.twilioConfig = twilioConfig;
    }

    @Override
    public void sendMessage(SmsRequest smsRequest) {
        PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
        PhoneNumber from = new PhoneNumber(twilioConfig.getTrialNumber());
        String message = smsRequest.getMessage();
        MessageCreator creator = Message.creator(to,from,message);
        creator.create();
    }
}
