package com.bychuong.kemshop.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class OrderEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    // @ManyToMany(mappedBy = "orders")
    // private List<ProductEntity> productEntity;


    // 1 nguoi --> n don hang
    @ManyToOne()
    @JoinColumn(name = "customer_id", nullable = false) // foreign key
    private CustomerEntity customer;

    // status
    private String status;
    //
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private PaymentEntity payment;

    @OneToMany(mappedBy = "order")
    List<OrderDetailEntity> orderDetails;
    // người nhận
    @Column(name = "receiver_name", nullable = false)
    private String receiverName;
    // sdt người nhận
    @Column(name = "receiver_phone", nullable = false)
    private String receiverPhone;
    // địa chỉ người nhận
    @Column(name = "receiver_address", nullable = false)
    private String receiverAddress;
    // tông tiền
    @Column(name = "total_price", nullable = false)
    private double totalAmount;

    // trạng thái
    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", nullable = false)
    private OrderStatus orderStatus;
}
