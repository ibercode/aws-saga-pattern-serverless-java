package com.ibercode.payment;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.ibercode.orders.model.OrderCreated;

public class PaymentProcess implements RequestHandler<OrderCreated, OrderCreated> {

    private final Gson GSON = new Gson();

    @Override
    public OrderCreated handleRequest(OrderCreated orderCreated, Context context) {

        // Process payment OK
        orderCreated.setPayment("Completed");
        return orderCreated;

        //SIMULATE PAYMENT FAILURE - uncomment line below
        //throw new PaymentException(orderCreated.getOrderId());
    }
}

