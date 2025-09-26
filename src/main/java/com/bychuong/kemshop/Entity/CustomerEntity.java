package com.bychuong.kemshop.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
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
@Table(name = "customers")
public class CustomerEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;
    @Column(name = "customer_name")
    private String customerName;

    @Email(message = "Email khong hop le.")
    @Column(name = "customer_email", nullable = false, unique = true)
    private String customerEmail;

    @Column(name = "customer_phone")
    private String customerPhone;
    @Column(name = "customer_address")
    private String customerAddress;
    @Column(name = "customer_image")
    private String image;
    @Min(value = 8, message = "Password phai tu 8 ki tu tro len.")
    @Column(name = "customer_password", nullable = false)
    private String password;


    // 1 nguoi --> n don hang
    @OneToMany(mappedBy ="customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderEntity> orders;

    // n nguoi --> 1 vai tro
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private RoleEnum role;

    // 1 nguoi - 1 gio hang

    @OneToOne(mappedBy = "customer")
    private CartEntity cart;
}
