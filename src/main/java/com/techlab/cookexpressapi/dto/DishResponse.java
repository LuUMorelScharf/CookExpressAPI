package com.techlab.cookexpressapi.dto;

import lombok.Data;

@Data
public class DishResponse {

  private Long id; // Incluir el ID al cliente
  private String name;
  private double price;
  private String category;
}