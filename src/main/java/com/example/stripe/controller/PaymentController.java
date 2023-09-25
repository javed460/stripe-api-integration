package com.example.stripe.controller;

import com.example.stripe.domain.PaymentRequest;
import com.example.stripe.dto.PaymentRequestDTO;
import com.example.stripe.service.PaymentService;
import com.stripe.exception.StripeException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.stripe.transformer.PaymentRequestTransformer.transform;

@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/create-intent")
    public String createPaymentIntent(@RequestBody PaymentRequestDTO paymentRequestDTO) throws StripeException {
        PaymentRequest paymentRequest = transform(paymentRequestDTO);
        return paymentService.createPayment(paymentRequest);
    }
}

