package com.example.bookstore.service;

import com.example.bookstore.model.ShoppingCart;
import com.example.bookstore.model.User;

public interface ShoppingCartService {

    ShoppingCart getByUser(User user);

    ShoppingCart addBook(User user, Long id, int quantity);

    ShoppingCart removeBook(User user, Long id);

    public void delete(Long id);
}
