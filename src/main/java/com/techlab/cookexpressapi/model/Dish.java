package com.techlab.cookexpressapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Dish {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private double price;
  private String category;
}
