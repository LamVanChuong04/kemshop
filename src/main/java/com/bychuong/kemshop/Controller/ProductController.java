package com.bychuong.kemshop.Controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bychuong.kemshop.DTO.ProductDTO;

import com.bychuong.kemshop.Service.Impl.ProductServiceImp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductServiceImp productServiceImp;

    public ProductController(ProductServiceImp productServiceImp) {
        this.productServiceImp = productServiceImp;
    }
    // lấy tất cả sản phẩm
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(productServiceImp.getAllProducts());
    }
    // lấy sản phẩm theo id
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productServiceImp.getProductById(id));
    }
    // thêm sản phẩm
    @PostMapping("/create-product")
    public String createProduct(@Valid @RequestBody ProductDTO dto) {
        productServiceImp.createProduct(dto);
        return "Thêm sản phẩm thành công";
    }
    // xóa sản phẩm
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productServiceImp.deleteProduct(id);
        return "Xóa sản phẩm thành công";
    }
    
    // cập nhật sản phẩm
    @PutMapping("update/{id}")
    public String putMethodName(@PathVariable String id, @RequestBody ProductDTO product) {
        productServiceImp.updateProduct(Long.parseLong(id), product);
        return "Cập nhật sản phẩm thành công";
    }
    
}