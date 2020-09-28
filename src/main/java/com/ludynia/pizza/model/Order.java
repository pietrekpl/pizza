package com.ludynia.pizza.model;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class Order {
    @NotBlank(message = "Field firstName and LastName is mandatory")
    private String name;
    @NotBlank(message = "Field street is mandatory")
    private String street;
    @NotBlank(message = "Field city is mandatory")
    private String city;
    @NotBlank(message = "Field state is mandatory")
    private String state;
    @NotBlank(message = "Field Zip Code is mandatory")
    private String zipCode;
    @CreditCardNumber(message = "Card is not valid")
    private String ccNumber;
    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",message = "Value must be in format mm/YY")
    private String ccExpiration;
    @Digits(integer = 3,fraction = 0,message = "CVV number is not correct")
    private String ccCVV;
}
