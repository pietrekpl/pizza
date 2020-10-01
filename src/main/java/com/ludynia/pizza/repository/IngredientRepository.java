package com.ludynia.pizza.repository;

import com.ludynia.pizza.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient,String> {

}
