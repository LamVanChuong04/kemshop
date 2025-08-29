package com.bychuong.kemshop.Service;

import org.springframework.stereotype.Service;

import com.bychuong.kemshop.Entity.ProductEntity;


@Service
public interface ProductService {
    // save product
    public void saveProduct(ProductEntity product);
}
