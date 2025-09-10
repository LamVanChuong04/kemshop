package com.bychuong.kemshop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.bychuong.kemshop.Service.Impl.CartServiceImp;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartServiceImp cartServiceImp;
    
    @PostMapping("/add")
    public ResponseEntity<String> addToCart(@RequestParam String email, @RequestParam long productId) {
        cartServiceImp.handleAddProductToCart(email, productId);
        return ResponseEntity.ok("Thêm sản phẩm vào giỏ hàng thành công!");
    }
}
