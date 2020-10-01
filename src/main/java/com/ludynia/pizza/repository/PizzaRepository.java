package com.ludynia.pizza.repository;

import com.ludynia.pizza.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Order,Long> {

}
