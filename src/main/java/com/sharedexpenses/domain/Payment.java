package com.sharedexpenses.domain;

import java.util.Date;

public class Payment {
    private final int paymentId;
    private static int paymentCounter;
    private String concept;
    private Friend payer;
    private Date date;

    private Payment(){ this.paymentId = ++Payment.paymentCounter;}

    public Payment(String concept, Friend payer, Date date){
        this();
        this.concept = concept;
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
