package com.ludynia.pizza.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class Pizza {
    @NotNull
    @Size(min = 2, message = "Name should contain at least 2 letters")
    private String name;
    @Size(min = 1, message = "Please choose at least 1 ingredient")
    private List<String>ingredientList;
}
