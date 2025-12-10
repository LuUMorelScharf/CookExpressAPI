package com.techlab.cookexpressapi.controller;

import com.techlab.cookexpressapi.model.Dish;
import com.techlab.cookexpressapi.service.IDishService;
import com.techlab.cookexpressapi.dto.DishRequest;
import com.techlab.cookexpressapi.dto.DishResponse;
import com.techlab.cookexpressapi.util.DishMapper;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/dishes")
public class DishController {

  private final IDishService service;

  public DishController(IDishService service) {
    this.service = service;
  }

  @GetMapping
  public List<DishResponse> getAll() {
    return service.getAll().stream()
        // Mapea cada Entidad -> DTO Response
        .map(DishMapper::toResponse)
        .collect(Collectors.toList());
  }

  @PostMapping
  public DishResponse create(@RequestBody DishRequest dishRequest) {

    Dish dishToCreate = DishMapper.toEntity(dishRequest);
    Dish savedDish = service.create(dishToCreate);
    return DishMapper.toResponse(savedDish);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    service.delete(id);
  }

  @PutMapping("/{id}")
  public DishResponse update(@PathVariable Long id, @RequestBody DishRequest dishRequest) {
    Dish dishToUpdate = DishMapper.toEntity(dishRequest);
    Dish updatedDish = service.update(id, dishToUpdate);
    return DishMapper.toResponse(updatedDish);
  }

  @GetMapping("/{id}")
  public DishResponse getById(@PathVariable Long id) {
    Dish dish = service.getById(id);
    return DishMapper.toResponse(dish); // Entidad -> DTO Response
  }

  @GetMapping("/filter")
  public List<DishResponse> getAllDishes(
      @RequestParam(defaultValue = "") String name,
      @RequestParam(defaultValue = "") String category) {

    List<Dish> filteredDishes = service.findAll(name, category);

    return filteredDishes.stream()
        .map(DishMapper::toResponse)
        .collect(Collectors.toList());
  }

}