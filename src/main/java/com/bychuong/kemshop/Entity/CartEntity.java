package com.bychuong.kemshop.Entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "carts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long Id;

    // user_Id
    @OneToOne()
    @JoinColumn(name = "user_Id")
    private CustomerEntity customer;

    // 1 gio hang-- n san pham

    @OneToMany(mappedBy = "cart")
    private List<CartDetailEntity> cartItem;

    // sum
    private double sum;
}
