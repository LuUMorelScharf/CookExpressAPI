package com.techlab.cookexpressapi.service;

import com.techlab.cookexpressapi.model.Dish;
import com.techlab.cookexpressapi.repository.DishRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DishService implements IDishService {

  private final DishRepository dishRepository;

  public DishService(DishRepository dishRepository) {
    this.dishRepository = dishRepository;
  }


  @Override
  public List<Dish> getAll() { return dishRepository.findAll(); }


  @Override
  public Dish create(Dish d) { return dishRepository.save(d); }


  @Override
  public void delete(Long id) { dishRepository.deleteById(id); }


  @Override
  public Dish update(Long id, Dish updatedDish) {
    return dishRepository.findById(id)
        .map(dish -> {
          // El .map() solo se ejecuta si el Dish existe
          updatedDish.setId(id);
          return dishRepository.save(updatedDish);
        })
        // Si el Optional estaba vacío (no encontró el ID), lanza una excepción
        .orElseThrow(() -> new RuntimeException("Dish not found with id: " + id));
  }

  @Override
  public List<Dish> findAll(String name, String category) {

    if(name.isEmpty() && category.isEmpty()) {
      return dishRepository.findAll();
    }

    if(!name.isEmpty() && !category.isEmpty()) {
      return dishRepository.findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(name, category);
    }

    if(!name.isEmpty()) {
      return dishRepository.findByNameContainingIgnoreCase(name);
    }

    return dishRepository.findByCategoryContainingIgnoreCase(category);
  }
  // DishService.java (Añadir este método)

  @Override
  public Dish getById(Long id) {
    // Busca el platillo por ID. Si no lo encuentra, lanza una excepción.
    return dishRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Dish not found with id: " + id));
  }
}