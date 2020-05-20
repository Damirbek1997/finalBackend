package com.example.EShop.Repository;

import com.example.EShop.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findOrderEntitiesByUserEmail(String email);
}
