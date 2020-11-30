package com.ludynia.pizza.twilio;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/sms")
public class SmsController {

    private final ServiceTwilio serviceTwilio;

    public SmsController(ServiceTwilio serviceTwilio) {
        this.serviceTwilio = serviceTwilio;
    }

    public void sendSms(@Valid @RequestBody SmsRequest smsRequest) {
        serviceTwilio.sendSms(smsRequest);
    }
}
