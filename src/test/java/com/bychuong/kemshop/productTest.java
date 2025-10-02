package com.bychuong.kemshop;

import java.util.Locale.Category;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bychuong.kemshop.Entity.CategoryEntity;
import com.bychuong.kemshop.Entity.ProductEntity;
import com.bychuong.kemshop.Service.Impl.ProductServiceImp;

@SpringBootTest
public class productTest {
    @Autowired
    private ProductServiceImp productServiceImp;

    @Test
    public void test() {
        // Create a new product entity
        ProductEntity p = new ProductEntity();
        p.setProductName("Kem vị Vani 1.0");
        p.setProductPrice(25.50);
        p.setProductDescription("Kem Vani ngon tuyệt");
        p.setProductImage("image_url");
        p.setQuantity(100);

        // set category: id category đã tồn tại trong db
        CategoryEntity c = new CategoryEntity();
        c.setCategoryId(2); 
        p.setCategory(c); 
        productServiceImp.saveProduct(p);
    }
}
