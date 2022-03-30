package com.ibercode.refund;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.ibercode.orders.model.OrderCreated;

public class RefundCustomer implements RequestHandler<OrderCreated, OrderCreated> {

    @Override
    public OrderCreated handleRequest(OrderCreated orderCreated, Context context) {

        // process refund
        orderCreated.setPayment("Refunded");
        orderCreated.setOrderStatus("Canceled");
        return orderCreated;
    }
}
