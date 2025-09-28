package com.bychuong.kemshop.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.bychuong.kemshop.DTO.ProductDTO;
import com.bychuong.kemshop.Entity.ProductEntity;


@Service
public interface ProductService {
    // save product
    public void saveProduct(ProductEntity product);
    List<ProductDTO> getAllProducts();
    ProductDTO getProductById(Long id);
    // delete product
    void deleteProduct(Long id);
    // create product
    ProductDTO createProduct(ProductDTO product);
    // update product
    ProductDTO updateProduct(Long id, ProductDTO product);

    // phân trang
    Page<ProductEntity> search(int pageNo, int pageSize);

    // search and sort
    Page<ProductEntity> searchSort(int pageNo, int pageSize);
}
