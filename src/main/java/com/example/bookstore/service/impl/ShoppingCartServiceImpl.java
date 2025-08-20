package com.example.bookstore.service.impl;

import com.example.bookstore.model.ShoppingCart;
import com.example.bookstore.model.User;
import com.example.bookstore.repository.ShoppingCartRepository;
import com.example.bookstore.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public ShoppingCart getByUser(User user) {
        return shoppingCartRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Cart is not found!"));
    }

    @Override
    public ShoppingCart addBook(User user, Long id, int quantity) {
        return null;
    }

    @Override
    public ShoppingCart removeBook(User user, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {
        shoppingCartRepository.findById(id);
    }
}
