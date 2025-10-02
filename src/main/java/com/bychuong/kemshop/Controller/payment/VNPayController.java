package com.bychuong.kemshop.Controller.payment;

import com.bychuong.kemshop.DTO.Request.VNPayRequest;
import com.bychuong.kemshop.Service.Impl.VNPayServiceImp;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class VNPayController {
    private VNPayServiceImp vnPayServiceImp;


    @PostMapping("/vnpay")
    public ResponseEntity<String> createPayment(@RequestBody VNPayRequest paymentRequest) {
        try {
            String paymentUrl = vnPayServiceImp.createPayment(paymentRequest);
            return ResponseEntity.ok(paymentUrl);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Đã xảy ra lỗi khi tạo thanh toán!");
        }
    }

    @GetMapping("/vnpayment/return")
    public ResponseEntity<String> returnPayment(@RequestParam("vnp_ResponseCode") String responseCode) {
        return vnPayServiceImp.handlePaymentReturn(responseCode);
    }
}
