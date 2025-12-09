package com.techlab.cookexpressapi.service;

import com.techlab.cookexpressapi.model.Order;
import com.techlab.cookexpressapi.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional; // Necesario para usar Optional en findById

@Service
public class OrderService {

  private final OrderRepository repo;

  public OrderService(OrderRepository repo) {
    this.repo = repo;
  }

  // CREATE (POST)
  public Order create(Order order) {
    order.setDate(LocalDateTime.now());
    return repo.save(order);
  }

  // READ ALL (GET)
  public List<Order> getAll() {
    return repo.findAll();
  }

  /**
   * ACTUALIZAR (PUT)
   * Encuentra una orden por ID y aplica los cambios del objeto updatedOrder.
   */
  public Order update(Long id, Order updatedOrder) {
    // Busca la orden existente. map() se ejecuta si existe.
    return repo.findById(id).map(existingOrder -> {

      // 1. Aplicar los cambios:
      // **Asegúrate que tu clase Order.java tiene los métodos set...**
      existingOrder.setCustomerName(updatedOrder.getCustomerName());
      existingOrder.setDishes(updatedOrder.getDishes());
      existingOrder.setTotal(updatedOrder.getTotal());

      // 2. Actualizar la fecha
      existingOrder.setDate(LocalDateTime.now());

      // 3. Guardar el objeto modificado
      return repo.save(existingOrder);

      // Si findById no encuentra la orden, lanza una RuntimeException, lo que Spring convierte en un 404.
    }).orElseThrow(() -> new RuntimeException("Orden no encontrada con ID: " + id));
  }

  /**
   * ELIMINAR (DELETE)
   * Elimina una orden por su ID.
   */
  public void delete(Long id) {
    repo.deleteById(id);
  }

  // Opcional: READ BY ID (Si lo necesitas para GET /api/orders/{id})
  public Optional<Order> getById(Long id) {
    return repo.findById(id);
  }
}