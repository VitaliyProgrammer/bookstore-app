package com.example.bookstore.controller.user;

import com.example.bookstore.model.CartItem;
import com.example.bookstore.service.CartItemService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartItemService cartItemService;

    public CartController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PostMapping("/add")
    public CartItem addToCart(@RequestBody CartItem cartItem) {
        return cartItemService.save(cartItem);
    }

    @GetMapping("/{cartId}")
    public List<CartItem> getCartItem(@PathVariable Long id) {
        return cartItemService.findByShoppingCartId(id);
    }

    @DeleteMapping("/{id}")
    public void deleteFromCart(@PathVariable Long id) {
        cartItemService.delete(id);
    }
}
