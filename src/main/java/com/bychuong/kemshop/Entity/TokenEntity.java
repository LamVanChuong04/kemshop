package com.bychuong.kemshop.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "tokens")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TokenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Column(unique = true)
    public String token;

    public boolean expired;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    public CustomerEntity customer;

    public boolean revoked;
    @Enumerated(EnumType.STRING)
    public TokenType  tokenType = TokenType.BEARER;


}
