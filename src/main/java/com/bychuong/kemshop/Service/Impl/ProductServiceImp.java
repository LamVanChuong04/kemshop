package com.bychuong.kemshop.Service.Impl;

import com.bychuong.kemshop.DTO.ProductDTO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.bychuong.kemshop.Entity.CategoryEntity;

import com.bychuong.kemshop.Entity.ProductEntity;

import com.bychuong.kemshop.Repository.CategoryRepository;

import com.bychuong.kemshop.Repository.ProductRepository;
import com.bychuong.kemshop.Service.ProductService;

import java.util.List;

import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    
    private ProductDTO toDTO(ProductEntity entity) {
        ProductDTO dto = new ProductDTO();
        dto.setId(entity.getId());
        dto.setProductName(entity.getProductName());
        dto.setProductPrice(entity.getProductPrice());
        dto.setProductDescription(entity.getProductDescription());
        dto.setProductImage(entity.getProductImage());
        dto.setQuantity(entity.getQuantity());
        dto.setCategoryId(entity.getCategory().getCategoryId());
        return dto;
    }

    @Override
    public void saveProduct(ProductEntity product) {
        productRepository.save(product);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductById(Long id) {
        return productRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm với id = " + id));
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // create product
    
    @Override
    public ProductDTO createProduct(ProductDTO dto) {
        ProductEntity product = new ProductEntity();
        product.setProductName(dto.getProductName());
        product.setProductPrice(dto.getProductPrice());
        product.setProductDescription(dto.getProductDescription());
        product.setProductImage(dto.getProductImage());
        product.setQuantity(dto.getQuantity());
        
        // check tên san phẩm đã tồn tại chưa
        if (productRepository.existsByProductName(product.getProductName())) {
            throw new IllegalArgumentException("Tên sản phẩm đã tồn tại, vui lòng nhập tên khác");
        }

        // lấy category từ DB
        CategoryEntity category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        product.setCategory(category);

        // lưu sản phẩm
        ProductEntity saved = productRepository.save(product);

        // convert về DTO để trả ra
        return toDTO(saved);
    }

    // update product
    @Override
    public ProductDTO updateProduct(Long id, ProductDTO dto) {
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setProductName(dto.getProductName());
        product.setProductPrice(dto.getProductPrice());
        product.setProductDescription(dto.getProductDescription());
        product.setProductImage(dto.getProductImage());
        product.setQuantity(dto.getQuantity());

        // lấy category từ DB
        CategoryEntity category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        product.setCategory(category);

        // lưu sản phẩm
        ProductEntity saved = productRepository.save(product);

        // convert về DTO để trả ra
        return toDTO(saved);
    }
    // phân trang
    @Override
    public Page<ProductEntity> search(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        return productRepository.search1(pageable);
    }

    // search and sort
    @Override
    public Page<ProductEntity> searchSort(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1, pageSize, Sort.by("productPrice").ascending());
        return productRepository.findAll(pageable);
    }
}
