package com.payment.service;

import com.payment.domain.PaymentMethod;
import com.payment.model.PaymentOrder;
import com.payment.payload.dto.BookingDTO;
import com.payment.payload.dto.UserDTO;
import com.payment.payload.response.PaymentLinkResponse;

public interface PaymentService {

    PaymentLinkResponse createOrder(UserDTO user, BookingDTO booking, PaymentMethod paymentMethod);


    PaymentOrder getPaymentOrderById(Long id) throws Exception;
    PaymentOrder getPaymentOrderByPaymentId(String paymentId);


    PaymentLink createRazorpayPaymentLink(UserDTO user, Long amount, Long orderId );

    String createStripePaymentLink(UserDTO user, Long amount, Long orderId );

    Boolean proceedPayment(PaymentOrder paymentOrder, String paymentId, String paymentLinkId);
}
