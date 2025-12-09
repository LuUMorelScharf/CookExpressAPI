package com.techlab.cookexpressapi.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity(name = "orders")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String customerName;
  private LocalDateTime date;

  @ManyToMany
  private List<Dish> dishes;

  private double total;
}
