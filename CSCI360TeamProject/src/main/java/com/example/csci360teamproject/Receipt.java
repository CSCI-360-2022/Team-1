package com.example.csci360teamproject;

public class Receipt {
    private double paymentTotal;
    private int eventId;

    public Receipt() {
        paymentTotal = 0;
    }

    public Receipt(double paymentTotal) {
        this.paymentTotal = paymentTotal;
    }

    public double getPaymentTotal() {
        return paymentTotal;
    }
}
