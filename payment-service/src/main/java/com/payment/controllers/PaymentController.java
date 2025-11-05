package com.payment.controllers;

import com.payment.domain.PaymentMethod;
import com.payment.model.PaymentOrder;
import com.payment.payload.dto.BookingDTO;
import com.payment.payload.dto.UserDTO;
import com.payment.payload.response.PaymentLinkResponse;
import com.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/create")
    public ResponseEntity<PaymentLinkResponse> createPaymentLink(@RequestBody BookingDTO booking,
                                                                 @RequestParam PaymentMethod paymentMethod){
        UserDTO user = new UserDTO();
        user.setFullName("AShoka");
        user.setEmail("ashoka@gmail.com");
        user.setId(1l);

        PaymentLinkResponse res = paymentService.createOrder(user,booking, paymentMethod);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/{paymentOrderId}")
    public ResponseEntity<PaymentOrder> getPaymentOrderById(
            @PathVariable Long PaymentOrderId ){


        PaymentOrder res = paymentService.getPaymentOrderById(paymentOrderId);
        return ResponseEntity.ok(res);
    }

    @PatchMapping("/proceed")
    public ResponseEntity<Boolean> proceedPayment(
            @RequestParam String paymentId ,
            @RequestParam String paymentLinkId){

        PaymentOrder paymentOrder = paymentService.getPaymentOrderByPaymentId(paymentLinkId)
        Boolean res = paymentService.proceedPayment(paymentOrder,paymentId,paymentLinkId);
        return ResponseEntity.ok(res);
    }

}
