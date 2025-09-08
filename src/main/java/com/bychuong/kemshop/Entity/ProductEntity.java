package com.bychuong.kemshop.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Table(name = "products")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name",nullable = false, unique = true)
    private String productName;

    @Column(name = "product_price", nullable = false)
    private double productPrice;


    @Column(name = "product_description",nullable = false)
    private String productDescription;

    @Column(name = "product_image", nullable = false)
    private String productImage;
    // n product -- n order
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable( name = "product_order",
            joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    private List<OrderEntity> orders;
    @Column(name = "product_quantity", nullable = false)
    private Integer quantity;

    // n product --> 1 category
    @ManyToOne()
    @JoinColumn(name = "category_id",  nullable = false)
    private CategoryEntity category;

    // 1 san pham -- n gio hang
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItemEntity> cartItems;
}
