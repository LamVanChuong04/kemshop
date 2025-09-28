package com.bychuong.kemshop.Controller;

import java.util.List;

import jakarta.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bychuong.kemshop.DTO.ProductDTO;
import com.bychuong.kemshop.Entity.ProductEntity;
import com.bychuong.kemshop.Service.Impl.ProductServiceImp;

import ch.qos.logback.core.model.Model;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductServiceImp productServiceImp;
    private final ModelMapper modelMapper;
    public ProductController(ProductServiceImp productServiceImp, ModelMapper modelMapper) {
        this.productServiceImp = productServiceImp;
        this.modelMapper = modelMapper;
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
    // phân trang
    @GetMapping("/searchPage")
    public ResponseEntity<?> getPage(@RequestParam(name = "pageNo") int pageNo, @RequestParam(name = "pageSize") int pageSize) {
        Page<ProductEntity> page = productServiceImp.search(pageNo, pageSize);
        return ResponseEntity.ok(page);
    }

    // search and sort
    @GetMapping("/searchSort")
    public ResponseEntity<?> getPageAndSort(@RequestParam(name = "pageNo") int pageNo, @RequestParam(name = "pageSize") int pageSize) {
        Page<ProductEntity> page = productServiceImp.searchSort(pageNo, pageSize);
        Page<ProductDTO> pageDto = page.map(product -> modelMapper.map(product, ProductDTO.class));

        return ResponseEntity.ok(pageDto);
    }
    
    
}