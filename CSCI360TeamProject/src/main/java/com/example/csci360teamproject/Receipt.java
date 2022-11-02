package com.example.csci360teamproject;

import java.time.LocalDate;
//import java.util.Date;

public class Receipt {
    private double paymentTotal;
    private int eventId;
    private int customerId;
    private LocalDate date;
    private long transactionId;

    public Receipt() {
        paymentTotal = 0;
    }

    public Receipt(double paymentTotal, int eventId, int customerId, LocalDate date, long transactionId) {
        this.paymentTotal = paymentTotal;
        this.eventId = eventId;
        this.customerId = customerId;
        this.date = date;
        this.transactionId = transactionId;
    }

    public double getPaymentTotal() {
        return paymentTotal;
    }

    public int getEventId() {
        return eventId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public LocalDate getDate() {
        return date;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setPaymentTotal(int i) {
        paymentTotal = i;
    }

    public void setEventId(int i) {
        eventId = i;
    }

    public void setCustomerId(int i) {
        customerId = i;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTransactionId(int i) {
        transactionId = i;
    }
}
