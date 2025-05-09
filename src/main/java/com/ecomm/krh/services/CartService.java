package com.ecomm.krh.services;

import com.ecomm.krh.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CartService {

    private static final String CART_PREFIX = "cart:";

    private final HashOperations<String, String, Integer> hashOps;

    @Autowired
    public CartService(RedisTemplate<String, String> redisTemplate) {
        this.hashOps = redisTemplate.opsForHash();
    }

    public void addToCart(String userId, CartItem item) {
        String key = CART_PREFIX + userId;
        hashOps.increment(key, item.getProductId(), item.getQuantity());
    }

    public List<CartItem> getCart(String userId) {
        String key = CART_PREFIX + userId;
        Map<String, Integer> entries = hashOps.entries(key);
        return entries.entrySet().stream()
                .map(e -> new CartItem(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    public void clearCart(String userId) {
        String key = CART_PREFIX + userId;
        hashOps.getOperations().delete(key);
    }
}

