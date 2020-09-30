package com.ludynia.pizza.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 2, message = "Name should contain at least 2 letters")
    private String name;

    @ManyToMany(targetEntity = Ingredient.class)
    @Size(min = 1, message = "Please choose at least 1 ingredient")
    private List<String>ingredientList;

    private Date created;

    @PrePersist
    void created () {
        this.created = new Date();
    }
}
