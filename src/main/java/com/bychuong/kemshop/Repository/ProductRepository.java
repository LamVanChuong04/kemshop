package com.bychuong.kemshop.Repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bychuong.kemshop.Entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    boolean existsByProductName(String productName);
    // phân trang
    @Query(value = "select * from products", countQuery = "select count(*) from products",nativeQuery = true)
    public Page<ProductEntity> search1(Pageable pageable);
    
    // search and sort
    
}
