package com.ludynia.pizza.model;

import lombok.Data;

@Data
public class Order {
    private String name;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
}
