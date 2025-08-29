package com.bychuong.kemshop.Service;

import org.springframework.stereotype.Service;

import com.bychuong.kemshop.Entity.CategoryEntity;

@Service
public interface CategoryService {
    // save category
    public void saveCategory(CategoryEntity categoryEntity);
}
