package com.ludynia.pizza.twilio;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ServiceTwilio {

    private final MessageSender messageSender;

    public ServiceTwilio(@Qualifier("twilio") MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void sendSms(SmsRequest smsRequest) {
        messageSender.sendMessage(smsRequest);
    }

}
