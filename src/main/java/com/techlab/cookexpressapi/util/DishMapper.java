package com.techlab.cookexpressapi.util;

import com.techlab.cookexpressapi.model.Dish;
import com.techlab.cookexpressapi.dto.DishRequest;
import com.techlab.cookexpressapi.dto.DishResponse;

public class DishMapper {


  public static Dish toEntity(DishRequest dto) {
    Dish entity = new Dish();
    // El ID no se asigna aquí
    entity.setName(dto.getName());
    entity.setPrice(dto.getPrice());
    entity.setCategory(dto.getCategory());
    return entity;
  }

  public static DishResponse toResponse(Dish entity) {
    DishResponse dto = new DishResponse();
    dto.setId(entity.getId());
    dto.setName(entity.getName());
    dto.setPrice(entity.getPrice());
    dto.setCategory(entity.getCategory());
    return dto;
  }
}