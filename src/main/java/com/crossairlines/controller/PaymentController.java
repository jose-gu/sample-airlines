package com.crossairlines.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.crossairlines.dto.request.PaymentRequest;
import com.crossairlines.dto.response.PaymentResponse;
import com.crossairlines.service.PaymentService;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/process")
    public ResponseEntity<PaymentResponse> processPayment(
            @Valid @RequestBody PaymentRequest paymentRequest,
            HttpServletRequest request) {
        
        PaymentResponse response = paymentService.processPayment(paymentRequest, request);
        return ResponseEntity.ok(response);
    }
}