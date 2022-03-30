package com.ibercode.fulfillment;

class StockException extends RuntimeException{

    public StockException(){
        super();
    }

    public StockException(String message) {
        super(message);
    }
}