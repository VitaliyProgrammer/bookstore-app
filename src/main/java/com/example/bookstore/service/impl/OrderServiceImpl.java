package com.example.bookstore.service.impl;

import com.example.bookstore.model.Order;
import com.example.bookstore.model.User;
import com.example.bookstore.repository.OrderRepository;
import com.example.bookstore.service.OrderService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public Order placeOrder(User user) {
        Order order = new Order();
        order.setUser(user);
        order.setStatus("Pending");
        return orderRepository.save(order);
    }

    @Override
    public List<Order> findByUser(User user) {
        return orderRepository.findByUser(user);
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order save(Order order) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Order updateStatus(Long id, String status) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order is not found!"));
        order.setStatus(status);
        orderRepository.save(order);
        return order;
    }

    @Override
    public void delete(Long order) {
        orderRepository.deleteById(order);
    }
}
