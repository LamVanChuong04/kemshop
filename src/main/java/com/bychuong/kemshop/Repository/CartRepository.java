package com.bychuong.kemshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bychuong.kemshop.Entity.CartEntity;
import com.bychuong.kemshop.Entity.CustomerEntity;
@Repository
public interface CartRepository  extends JpaRepository<CartEntity, Long> {
    CartEntity findByCustomer(CustomerEntity customer);
}
