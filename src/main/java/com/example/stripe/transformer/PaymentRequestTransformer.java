package com.example.stripe.transformer;

import com.example.stripe.domain.PaymentRequest;
import com.example.stripe.dto.PaymentRequestDTO;

public final class PaymentRequestTransformer {
    public static PaymentRequest transform(PaymentRequestDTO paymentRequestDTO) {
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setAmount(paymentRequestDTO.getAmount());
        paymentRequest.setCurrency(paymentRequestDTO.getCurrency());
        return paymentRequest;
    }
}