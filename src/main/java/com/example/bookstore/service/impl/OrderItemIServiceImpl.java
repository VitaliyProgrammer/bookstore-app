package com.example.bookstore.service.impl;

import com.example.bookstore.model.OrderItem;
import com.example.bookstore.repository.OrderItemRepository;
import com.example.bookstore.service.OrderItemService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderItemIServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;

    public OrderItemIServiceImpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public OrderItem save(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public List<OrderItem> findByOrderId(Long id) {
        return orderItemRepository.findByOrderId(id);
    }
}
