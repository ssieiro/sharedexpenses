package com.sharedexpenses.domain.datamodels;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Payment {
    private String concept;
    private BigDecimal amount;
    private Friend payer;
    private LocalDateTime date;

    public Payment(){}

    public Payment(String concept, BigDecimal amount, Friend payer, LocalDateTime date){
        this.concept = concept;
        this.amount = amount;
        this.payer = payer;
        this.date = date;
    }

    public String getConcept() {
        return concept;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Friend getPayer() {
        return payer;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "concept='" + concept + '\'' +
                ", amount=" + amount +
                ", payer=" + payer +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return concept.equals(payment.concept) && amount.equals(payment.amount) && payer.equals(payment.payer) && date.equals(payment.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(concept, amount, payer, date);
    }
}
