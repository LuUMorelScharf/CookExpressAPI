package com.techlab.cookexpressapi.repository;

import com.techlab.cookexpressapi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
