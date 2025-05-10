package com.example.ecom.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Payment {
    private int paymentId;
    private String paymentMethod;    //UPI, CREDIT CARD,DEBIT CARD,WALLET
    private LocalDateTime paymentDateAndTime;
    private String paymentStatus;
    private int paymentAmount;
}
