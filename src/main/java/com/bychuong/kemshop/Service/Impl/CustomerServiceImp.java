package com.bychuong.kemshop.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bychuong.kemshop.Entity.CustomerEntity;
import com.bychuong.kemshop.Repository.CustomerRepository;
import com.bychuong.kemshop.Service.CustomerService;

@Service
public class CustomerServiceImp implements CustomerService{
    
    @Autowired
    private CustomerRepository customerRepository;

    // SAVE CUSTOMER
    @Override
    public void saveCustomer(CustomerEntity customerEntity) {
        customerRepository.save(customerEntity);
    }
}
