package com.ludynia.pizza.repository;

import com.ludynia.pizza.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UserRepository extends CrudRepository<User,Long> {

    User findByUsername(String username);
}
