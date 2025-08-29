package com.bychuong.kemshop;

import com.bychuong.kemshop.Entity.CategoryEntity;
import com.bychuong.kemshop.Entity.CustomerEntity;
import com.bychuong.kemshop.Service.Impl.CategoryServiceImp;
import com.bychuong.kemshop.Service.Impl.CustomerServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class customerTest {
    @Autowired
    private CustomerServiceImp customerServiceImp;

    @Autowired
    private CategoryServiceImp categoryServiceImp;
    @Test
    public void test() {
        CustomerEntity c = new CustomerEntity();
        c.setCustomerAddress("Hoài Phú");
        c.setCustomerName("Lâm Văn Chương");
        c.setCustomerEmail("124@gmail.com");
        c.setCustomerPhone("0123456789");
        c.setImage("abcDF");
        c.setPassword("123456");
        customerServiceImp.saveCustomer(c);
    }
    @Test
    public void test1() {
        CategoryEntity c = new CategoryEntity();
        c.setCategoryName("Kem vị Vani");
        categoryServiceImp.saveCategory(c);
    }
}
