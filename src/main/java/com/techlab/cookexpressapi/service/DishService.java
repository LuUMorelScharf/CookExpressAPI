package com.techlab.cookexpressapi.service;

import com.techlab.cookexpressapi.model.Dish;
import com.techlab.cookexpressapi.repository.DishRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DishService {

  private final DishRepository repo;

  public DishService(DishRepository repo) {
    this.repo = repo;
  }

  public List<Dish> getAll() { return repo.findAll(); }

  public Dish create(Dish d) { return repo.save(d); }

  public void delete(Long id) { repo.deleteById(id); }
}
