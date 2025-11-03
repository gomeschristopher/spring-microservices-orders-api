package com.gomeschristopher.orders.dto;


import com.gomeschristopher.orders.model.Payment;
import com.gomeschristopher.orders.model.PaymentStatus;

import java.math.BigDecimal;

public record PaymentDTO(
         Long id,
         BigDecimal value,
         String name,
         String number,
         String expiration,
         String code,
         PaymentStatus status,
         Long orderId,
         Long paymentMethodId
) {
    public PaymentDTO(Payment payment) {
        this(
                payment.getId(),
                payment.getValue(),
                payment.getName(),
                payment.getNumber(),
                payment.getExpiration(),
                payment.getCode(),
                payment.getStatus(),
                payment.getOrderId(),
                payment.getPaymentMethodId()
        );
    }
}
