package com.ludynia.pizza.model;

import lombok.Data;
import lombok.Generated;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "pizza_order")
public class Order implements Serializable {

    private static final long serialUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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
    private Date created;

    @PrePersist
    public void created(){
        this.created = new Date();
    }

    @ManyToMany(targetEntity = Pizza.class)
    private List<Pizza>pizzas = new ArrayList<>();

    public void addCreator(Pizza creator){
        this.pizzas.add(creator);
    }


}
