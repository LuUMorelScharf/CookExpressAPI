package com.techlab.cookexpressapi.service;

import com.techlab.cookexpressapi.model.Dish;
import java.util.List;

public interface IDishService {

  List<Dish> getAll();

  Dish create(Dish d);

  void delete(Long id);

  Dish getById(Long id);

  Dish update(Long id, Dish updatedDish);

  List<Dish> findAll(String name, String category);
}