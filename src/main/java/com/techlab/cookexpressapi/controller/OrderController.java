package com.techlab.cookexpressapi.controller;

import com.techlab.cookexpressapi.model.Order;
import com.techlab.cookexpressapi.service.OrderService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus; // Probablemente falte también para HttpStatus.NO_CONTENT
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

  private final OrderService service;

  public OrderController(OrderService service) {
    this.service = service;
  }

  @GetMapping
  public List<Order> getAll() { return service.getAll(); }

  @PostMapping
  public Order create(@RequestBody Order order) { return service.create(order); }

  // Nuevo método para ACTUALIZAR
  @PutMapping("/{id}")
  public Order update(@PathVariable Long id, @RequestBody Order updatedOrder) {
    return service.update(id, updatedOrder);
  }

  // Nuevo método para ELIMINAR
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    service.delete(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
