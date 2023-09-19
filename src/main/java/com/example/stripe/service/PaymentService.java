package com.example.stripe.service;

import com.example.stripe.domain.PaymentRequest;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Value("${stripe.apiKey}")
    private String stripeApiKey;

    public String createPayment(PaymentRequest paymentRequest) throws StripeException {
        Stripe.apiKey = stripeApiKey;

        PaymentIntentCreateParams createParams = new PaymentIntentCreateParams.Builder()
                .setAmount(paymentRequest.getAmount())
                .setCurrency("usd")
                .setDescription("Example Payment")
                .build();

        PaymentIntent paymentIntent = PaymentIntent.create(createParams);
        return paymentIntent.getId();

    }
}
