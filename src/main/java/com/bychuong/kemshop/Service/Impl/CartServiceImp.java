package com.bychuong.kemshop.Service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bychuong.kemshop.Entity.CartDetailEntity;
import com.bychuong.kemshop.Entity.CartEntity;
import com.bychuong.kemshop.Entity.CustomerEntity;
import com.bychuong.kemshop.Entity.ProductEntity;
import com.bychuong.kemshop.Repository.CartDetailRepository;
import com.bychuong.kemshop.Repository.CartRepository;

import com.bychuong.kemshop.Repository.CustomerRepository;
import com.bychuong.kemshop.Repository.ProductRepository;
import com.bychuong.kemshop.Service.CartService;

@Service
public class CartServiceImp implements CartService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;

   
    @Autowired
    private CartDetailRepository cartDetailRepository;
    @Autowired
    private CartRepository cartRepository;

    @Override
    public void handleAddProductToCart(String email, long productId) {

        CustomerEntity user = this.customerRepository.findCustomerBycustomerEmail(email);
        if (user != null) {
            // check user đã có Cart chưa ? nếu chưa -> tạo mới
            CartEntity cart = this.cartRepository.findByCustomer(user);

            if (cart == null) {
                // tạo mới cart
                CartEntity otherCart = new CartEntity();
                otherCart.setCustomer(user);
                otherCart.setSum(1);

                cart = this.cartRepository.save(otherCart);
            }

            // save cart_detail
            // tìm product by id

            Optional<ProductEntity> productOptional = this.productRepository.findById(productId);
            if (productOptional.isPresent()) {
                ProductEntity realProduct = productOptional.get();

                CartDetailEntity cd = new CartDetailEntity();
                cd.setCart(cart);
                cd.setProduct(realProduct);
                
                cd.setQuantity(1);
                this.cartDetailRepository.save(cd);
            }

        }
    }
}
