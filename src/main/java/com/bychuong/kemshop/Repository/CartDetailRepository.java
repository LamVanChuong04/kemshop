package com.bychuong.kemshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bychuong.kemshop.Entity.CartDetailEntity;
@Repository
public interface CartDetailRepository extends JpaRepository<CartDetailEntity, Long> {
    
}
