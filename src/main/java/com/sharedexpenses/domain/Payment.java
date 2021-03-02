package com.sharedexpenses.domain;

import java.util.Date;

public class Payment {
    private final int paymentId;
    private static int paymentCounter;
    private String concept;
    private double amount;
    private Friend payer;
    private Date date;

    private Payment(){ this.paymentId = ++Payment.paymentCounter;}

    public Payment(String concept, double amount, Friend payer, Date date){
        this();
        this.concept = concept;
        this.amount = amount;
        this.payer = payer;
        this.date = date;
    }
    public int getPaymentId() {
        return paymentId;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Friend getPayer() {
        return payer;
    }

    public void setPayer(Friend payer) {
        this.payer = payer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", concept='" + concept + '\'' +
                ", payer=" + payer +
                ", date=" + date +
                '}';
    }
}
