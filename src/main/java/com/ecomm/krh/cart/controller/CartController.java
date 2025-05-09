package com.ecomm.krh.cart.controller;

import com.ecomm.krh.model.CartItem;
import com.ecomm.krh.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/{userId}")
    public String addToCart(@PathVariable String userId, @RequestBody CartItem item) {
        cartService.addToCart(userId, item);
        return "Item added to cart";
    }

    @GetMapping("/{userId}")
    public List<CartItem> getCart(@PathVariable String userId) {
        return cartService.getCart(userId);
    }

    @DeleteMapping("/{userId}")
    public String clearCart(@PathVariable String userId) {
        cartService.clearCart(userId);
        return "Cart cleared";
    }
}

