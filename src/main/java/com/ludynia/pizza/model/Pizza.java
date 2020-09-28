package com.ludynia.pizza.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class Pizza {
    @NotNull
    @Size(min = 3, message = "Name should contain at least 3 letters")
    private String name;
    @Size(min = 1, message = "Please choose at least 1 ingredient")
    private List<Ingredient>ingredientList;
}
