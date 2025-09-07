package com.bychuong.kemshop.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cart_items")
public class CartItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 1 gio hang --- n san pham
    @ManyToOne()
    @JoinColumn(name = "cart_id")
    private CartEntity cart;

    //
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    private Integer quantity;
}
