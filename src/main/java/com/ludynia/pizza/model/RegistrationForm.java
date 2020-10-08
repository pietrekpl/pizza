package com.ludynia.pizza.model;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {
    private String username;
    private String password;
    private String fullName;
    private String city;
    private String street;
    private String state;
    private String zipCode;
    private String telephoneNumber;


    public User toUser(PasswordEncoder passwordEncoder){
        return new User(username, passwordEncoder.encode(password),fullName,city,street,state,zipCode,telephoneNumber);
    }
}
