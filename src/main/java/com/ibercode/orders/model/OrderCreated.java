package com.ibercode.orders.model;

public class OrderCreated {

    private String orderId;
    private String customerId;
    private String amount;
    private String orderStatus;
    private String payment;

    public OrderCreated() {
    }

    public OrderCreated(String orderId, String customerId, String amount, String orderStatus, String payment) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.amount = amount;
        this.orderStatus = orderStatus;
        this.payment = payment;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }


    @Override
    public String toString() {
        return "OrderCreated{" +
                "orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", amount='" + amount + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", payment='" + payment + '\'' +
                '}';
    }
}
