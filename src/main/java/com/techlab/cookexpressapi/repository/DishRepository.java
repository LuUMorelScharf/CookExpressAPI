package com.techlab.cookexpressapi.repository;

import com.techlab.cookexpressapi.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Long> {
}
