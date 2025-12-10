package com.techlab.cookexpressapi.repository;

import com.techlab.cookexpressapi.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Long> {
  List<Dish> findByNameContainingIgnoreCase(String name);
  List<Dish> findByCategoryContainingIgnoreCase(String category);
  List<Dish> findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(String name, String category);

}
