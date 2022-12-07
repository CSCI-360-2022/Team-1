package com.example.csci360teamproject;

public class PaymentInfo {
    public String cardNum;
    public String expDate;
    public String cvv;

    public String zipCode;

    public PaymentInfo(String num, String exp, String cvv, String zip){
        cardNum = num;
        expDate = exp;
        this.cvv = cvv;
        zipCode = zip;
    }

    public String getCardNum() {
        return cardNum;
    }
    public String getExpDate(){
        return expDate;
    }

    public String getCvv() {
        return cvv;
    }

    public String getZipCode() {
        return zipCode;
    }
}
