package com.bychuong.kemshop.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bychuong.kemshop.Entity.CategoryEntity;

@Service
public interface CategoryService {
    // save category
    public void saveCategory(CategoryEntity categoryEntity);

    // find category by id
    public CategoryEntity getCategoryById(Integer id);
    // get all categories
    public List<CategoryEntity> getAllCategories();
}
