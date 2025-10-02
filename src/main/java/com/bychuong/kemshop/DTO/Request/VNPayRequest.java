package com.bychuong.kemshop.DTO.Request;

import lombok.Data;

import java.math.BigDecimal;

@Data

public class VNPayRequest {
    private BigDecimal amount;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
