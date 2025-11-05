package com.payment.repository;

import com.payment.model.PaymentOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public class PaymentOrderRepository extends JpaRepository<PaymentOrder, Long> {
    PaymentOrder findByPaymentLinkId(String paymentLinkId);
}
