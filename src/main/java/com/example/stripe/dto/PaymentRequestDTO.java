package com.example.stripe.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PaymentRequestDTO {
    private Long amount;
    private String currency;
}
