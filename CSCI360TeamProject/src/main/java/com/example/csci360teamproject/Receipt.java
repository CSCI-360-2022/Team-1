package com.example.csci360teamproject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
//import java.util.Date;


public class Receipt {
    private Service csci360TeamProjectService;
    private double paymentTotal;
    private int eventId;
    private int customerId;
    private LocalDate date;
    private long transactionId;

    public Receipt() {
        paymentTotal = 0;
    }

    public Receipt(double paymentTotal, int eventId, int customerId, LocalDate date, long transactionId, Service csci360TeamProjectService) {
        this.paymentTotal = paymentTotal;
        this.eventId = eventId;
        this.customerId = customerId;
        this.date = date;
        this.transactionId = transactionId;
        this.csci360TeamProjectService = csci360TeamProjectService;
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

    public String buildReceipt() {
        User user = csci360TeamProjectService.findUser(customerId);
        Event event = csci360TeamProjectService.findEvent(eventId);
        String retString = "";
        retString += "Transaction ID: " + transactionId + "\n";
        retString += "Customer Name: " + user.getUsername() + "\n";
        retString += "Date of Purchase: " + date.format(DateTimeFormatter.ofPattern("M/d/yy")) + "\n";
        retString += "Purchase Details:\n";
        retString += "    Event Name: " + event.getEventName() + "\n";
        retString += "    When: " + event.getDate().format(DateTimeFormatter.ofPattern("M/d/yy")) + "\n";
        retString += "    Location: " + event.getLocation() + "\n";
        retString += "    Ticket Cost: " + String.format("$%.2f", event.getPrice()) + "\n";
        retString += "Tax: " + String.format("$%.2f", paymentTotal-event.getPrice()) + "\n";
        retString += "Total Cost: " + String.format("$%.2f", paymentTotal);
        return retString;
    }
}
