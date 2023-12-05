package com.dailycodebuffer.OrderService.Service;

import com.dailycodebuffer.OrderService.Model.OrderRequest;
import com.dailycodebuffer.OrderService.Model.OrderResponse;

public interface OrderService {
   public long placeOrder(OrderRequest orderRequest);

   public  OrderResponse getOrderDetails(long orderId);
}
