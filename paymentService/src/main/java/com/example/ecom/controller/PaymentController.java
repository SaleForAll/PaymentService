package com.example.ecom.controller;

import com.example.ecom.model.Payment;
import com.example.ecom.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ecom/api/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/ecom/order/{orderId}")
    public String getPayment(Order orderId) {
        return paymentService.getPayment();
    }

    @PostMapping
    public Payment makePayment(Payment payment) {
       return paymentService.processPayment(payment);
    }

}
