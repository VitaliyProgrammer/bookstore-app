package com.example.bookstore.service.impl;

import com.example.bookstore.model.CartItem;
import com.example.bookstore.repository.CartItemRepository;
import com.example.bookstore.service.CartItemService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;

    public CartItemServiceImpl(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public CartItem save(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @Override
    public void delete(Long id) {
        cartItemRepository.deleteById(id);
    }

    @Override
    public List<CartItem> findByShoppingCartId(Long id) {
       return cartItemRepository.findByShoppingCartId(id);
    }
}
