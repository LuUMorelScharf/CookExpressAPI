package com.techlab.cookexpressapi.dto;

import lombok.Data;
// Usamos jakarta.validation para buenas prácticas, si lo tienes configurado
// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.Positive;

@Data
public class DishRequest {

  // [Opcional: Añade @NotBlank o @Positive si usas validación]
  private String name;
  private double price;
  private String category;
}