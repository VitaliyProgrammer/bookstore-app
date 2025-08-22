package com.example.bookstore.service;

import com.example.bookstore.model.Order;
import com.example.bookstore.model.User;
import java.util.List;
import java.util.Optional;

public interface OrderService {

    Order placeOrder(User user);

    List<Order> findByUser(User user);

    Optional<Order> findById(Long id);

    Order save(Order order);

    List<Order> findAll();

    Order updateStatus(Long id, String status);

    void delete(Long order);
}
