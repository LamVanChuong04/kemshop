package com.bychuong.kemshop.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bychuong.kemshop.DTO.ProductDTO;
import com.bychuong.kemshop.Entity.ProductEntity;
import com.bychuong.kemshop.Repository.ProductRepository;
import com.bychuong.kemshop.Service.Impl.ProductServiceImp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


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
    public String createProduct(@RequestBody ProductDTO dto) {
        productServiceImp.createProduct(dto);
        return "Thêm sản phẩm thành công";
    }

    

    
}
