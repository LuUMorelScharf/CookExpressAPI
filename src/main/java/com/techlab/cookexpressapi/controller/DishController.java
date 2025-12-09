package com.techlab.cookexpressapi.controller;

import com.techlab.cookexpressapi.model.Dish;
import com.techlab.cookexpressapi.service.DishService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/dishes")
public class DishController {

  private final DishService service;

  public DishController(DishService service) {
    this.service = service;
  }

  @GetMapping
  public List<Dish> getAll() { return service.getAll(); }

  @PostMapping
  public Dish create(@RequestBody Dish dish) { return service.create(dish); }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) { service.delete(id); }
}
