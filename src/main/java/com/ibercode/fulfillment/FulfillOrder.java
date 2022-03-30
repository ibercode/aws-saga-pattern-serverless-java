package com.ibercode.fulfillment;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.ibercode.orders.model.OrderCreated;

public class FulfillOrder implements RequestHandler<OrderCreated, OrderCreated> {

    @Override
    public OrderCreated handleRequest(OrderCreated orderCreated, Context context) {

        // Pick and Pack Order
        orderCreated.setOrderStatus("Completed");
        orderCreated.setPayment("Completed");
        return orderCreated;

        //SIMULATE STOCK IS UNAVAILABLE - uncomment line below
        //throw new StockException(orderCreated.getOrderId());
    }
}

