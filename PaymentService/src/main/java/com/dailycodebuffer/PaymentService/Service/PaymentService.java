package com.dailycodebuffer.PaymentService.Service;

import com.dailycodebuffer.PaymentService.Model.PaymentRequest;
import com.dailycodebuffer.PaymentService.Model.PaymentResponse;

public interface PaymentService {
   public Long doPayment(PaymentRequest paymentRequest);

   public  PaymentResponse getPaymentDetailsByOrderId(String orderId);
}
