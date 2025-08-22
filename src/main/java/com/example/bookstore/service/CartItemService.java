package com.example.bookstore.service;

import com.example.bookstore.model.CartItem;
import java.util.List;

public interface CartItemService {

    CartItem save(CartItem cartItem);

    void delete(Long id);

    List<CartItem> findByShoppingCartId(Long id);
}
