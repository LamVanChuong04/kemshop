package com.bychuong.kemshop.Service;

import org.springframework.stereotype.Service;

import com.bychuong.kemshop.Entity.CustomerEntity;

@Service
public interface CustomerService {
    // save customer
    public void saveCustomer(CustomerEntity customerEntity);
    
} 
