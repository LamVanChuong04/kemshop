package com.bychuong.kemshop.Service;

import com.bychuong.kemshop.DTO.Request.VNPayRequest;
import org.springframework.http.ResponseEntity;

import java.io.UnsupportedEncodingException;

public interface VNPayService {
    public String createPayment(VNPayRequest paymentRequest) throws UnsupportedEncodingException;
    public ResponseEntity<String> handlePaymentReturn(String responseCode);

}
