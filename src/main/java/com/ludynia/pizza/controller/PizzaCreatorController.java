package com.ludynia.pizza.controller;


import com.ludynia.pizza.model.Ingredient;
import com.ludynia.pizza.model.Order;
import com.ludynia.pizza.model.Pizza;
import com.ludynia.pizza.repository.IngredientRepository;
import com.ludynia.pizza.repository.PizzaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/creator")
public class PizzaCreatorController {

    private PizzaRepository pizzaRepository;

    private IngredientRepository ingredientRepository;

    public PizzaCreatorController(PizzaRepository pizzaRepository, IngredientRepository ingredientRepository) {
        this.pizzaRepository = pizzaRepository;
        this.ingredientRepository = ingredientRepository;
    }


    @GetMapping
    public String showCreatorForm(Model model) {
        List<Ingredient> ingredientList = Arrays.asList(
                new Ingredient("MOZZ", "mozzarella", Ingredient.Type.CHEESE),
                new Ingredient("MOZB", "mozzarellaBall", Ingredient.Type.CHEESE),
                new Ingredient("CHED", "cheddar", Ingredient.Type.CHEESE),
                new Ingredient("PEPP", "pepperoni", Ingredient.Type.MEAT),
                new Ingredient("BACO", "bacon", Ingredient.Type.MEAT),
                new Ingredient("HAMM", "ham", Ingredient.Type.MEAT),
                new Ingredient("PORK", "pork", Ingredient.Type.MEAT),
                new Ingredient("BEEF", "beef", Ingredient.Type.MEAT),
                new Ingredient("MUSH", "mushroom", Ingredient.Type.VEGETABLE),
                new Ingredient("PINE", "pineapple", Ingredient.Type.VEGETABLE),
                new Ingredient("GPEP", "greenPepper", Ingredient.Type.VEGETABLE),
                new Ingredient("ONIO", "onion", Ingredient.Type.VEGETABLE),
                new Ingredient("TOMA", "tomato", Ingredient.Type.VEGETABLE),
                new Ingredient("JALA", "jalapeno", Ingredient.Type.VEGETABLE),
                new Ingredient("CORN", "corn", Ingredient.Type.VEGETABLE),
                new Ingredient("OLIV", "blackOlive", Ingredient.Type.VEGETABLE),
                new Ingredient("MIXV", "vegetableMix", Ingredient.Type.VEGETABLE),
                new Ingredient("TOMS", "tomatoSauce", Ingredient.Type.SAUCE),
                new Ingredient("BECH", "bechamel", Ingredient.Type.SAUCE),
                new Ingredient("BBQS", "bbq", Ingredient.Type.SAUCE)
        );
        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredientList, type));
        }
        model.addAttribute("creator", new Pizza());
        return "creator";
    }

    private List<Ingredient> filterByType(
            List<Ingredient> ingredientList, Ingredient.Type type) {
        return ingredientList
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());


    } @PostMapping
    public String processCreator(@Valid Pizza creator, @ModelAttribute Order order, Errors errors){
        if (errors.hasErrors()){
            return "creator";
        }
        log.info("Pizza : "+ creator);
        return "redirect:/orders/current";
    }
}
