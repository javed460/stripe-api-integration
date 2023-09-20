package com.example.stripe.domain;

import lombok.Data;

@Data
public class PaymentRequest {
    private Long amount;
    private String currency;
}
