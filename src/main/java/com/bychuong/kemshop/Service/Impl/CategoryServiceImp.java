package com.bychuong.kemshop.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bychuong.kemshop.Entity.CategoryEntity;
import com.bychuong.kemshop.Repository.CategoryRepository;
import com.bychuong.kemshop.Service.CategoryService;

@Service
public class CategoryServiceImp implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    // SAVE CATEGORY
    @Override
    public void saveCategory(CategoryEntity categoryEntity) {
        categoryRepository.save(categoryEntity);
    }
    // find category by id
    @Override
    public CategoryEntity getCategoryById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy danh mục với id = " + id));
    }
}
