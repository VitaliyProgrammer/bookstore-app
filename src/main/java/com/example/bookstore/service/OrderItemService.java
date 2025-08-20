package com.example.bookstore.service;

import com.example.bookstore.model.OrderItem;
import java.util.List;

public interface OrderItemService {

    OrderItem save(OrderItem orderItem);

    List<OrderItem> findByOrderId(Long id);
}
