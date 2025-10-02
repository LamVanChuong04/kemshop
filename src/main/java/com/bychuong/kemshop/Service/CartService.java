package com.bychuong.kemshop.Service;

import org.springframework.stereotype.Service;

@Service
public interface CartService {
    // add product to cart
    public void handleAddProductToCart(String email, long productId);
}
