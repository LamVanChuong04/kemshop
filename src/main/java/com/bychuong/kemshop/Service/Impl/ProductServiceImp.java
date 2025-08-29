package com.bychuong.kemshop.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bychuong.kemshop.Entity.ProductEntity;
import com.bychuong.kemshop.Repository.ProductRepository;
import com.bychuong.kemshop.Service.ProductService;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void saveProduct(ProductEntity product) {
        productRepository.save(product);
    }
}
