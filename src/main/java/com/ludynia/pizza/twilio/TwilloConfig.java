package com.ludynia.pizza.twilio;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TwilloConfig {

    private String accountSid;
    private String authToken;
    private String trialNumber;

}
