package com.example.ecom.service;

import com.example.ecom.model.Payment;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentService {

    public String getPayment(){
        Payment payment = new Payment();
        return "payment";
    }

    public Payment processPayment(Payment payment){
        payment.setPaymentDateAndTime(LocalDateTime.now());
        payment.setPaymentStatus("Success");
        return payment;
    }
}
