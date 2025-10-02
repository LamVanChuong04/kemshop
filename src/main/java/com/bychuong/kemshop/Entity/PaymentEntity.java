package com.bychuong.kemshop.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "payments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;
    private String method;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;


    // order_Id
    @OneToOne()
    @JoinColumn(name = "order_Id")
    private OrderEntity order;
}
