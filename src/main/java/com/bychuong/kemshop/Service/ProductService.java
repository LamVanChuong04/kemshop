package com.bychuong.kemshop.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bychuong.kemshop.DTO.ProductDTO;
import com.bychuong.kemshop.Entity.ProductEntity;


@Service
public interface ProductService {
    // save product
    public void saveProduct(ProductEntity product);
    List<ProductDTO> getAllProducts();
    ProductDTO getProductById(Long id);
    void deleteProduct(Long id);
    // create product
    ProductDTO createProduct(ProductDTO product);
}
