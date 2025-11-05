package com.payment.model;

import com.payment.domain.PaymentMethod;
import com.payment.domain.PaymentOrderStatus;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PaymentOrder {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long amount;

    @Column(nullable = false)
    private PaymentOrderStatus status = PaymentOrderStatus.PENDING;

    @Column(nullable = false)
    private PaymentMethod paymentMethod;

    @Column(nullable = false)
    private String paymentLinkId;

    @Column(nullable = false)
    private  Long userId;

    @Column(nullable = false)
    private Long salonId;

    @Column(nullable = false)
    private Long bookingId;






}
