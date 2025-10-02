package com.bychuong.kemshop.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
@Builder
public class CustomerEntity extends BaseEntity implements UserDetails {
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
    //@Min(value = 8, message = "Password phai tu 8 ki tu tro len.")
    @Column(name = "customer_password", nullable = false)
    private String password;


    // 1 nguoi --> n don hang
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderEntity> orders;

    // n nguoi --> 1 vai tro
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private RoleEnum role;

    // 1 nguoi - 1 gio hang

    @OneToOne(mappedBy = "customer")
    private CartEntity cart;

    // token
    @OneToMany(mappedBy = "customer")
    private List<TokenEntity> tokens;

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return customerEmail;
    }

    @Override
    public String getPassword() {
        return password;
    }
}


