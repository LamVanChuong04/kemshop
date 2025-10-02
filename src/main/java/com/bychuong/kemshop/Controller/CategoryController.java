package com.bychuong.kemshop.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bychuong.kemshop.Entity.CategoryEntity;
import com.bychuong.kemshop.Service.Impl.CategoryServiceImp;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryServiceImp categoryServiceImp;
    public CategoryController(CategoryServiceImp categoryServiceImp) {
        this.categoryServiceImp = categoryServiceImp;
    }

    // get all categories
    @GetMapping()
    public ResponseEntity<List<CategoryEntity>> getMethodName() {
        return ResponseEntity.ok(categoryServiceImp.getAllCategories());
    }
    
}
