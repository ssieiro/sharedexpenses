package com.sharedexpenses.domain.datamodels;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Payment {
    private long id;
    private String concept;
    private BigDecimal amount;
    private long friend_id;
    private LocalDateTime date;

    public Payment(){}

    public Payment(String concept, BigDecimal amount, long friendId, LocalDateTime date){
        this.concept = concept;
        this.amount = amount;
        this.friend_id = friendId;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public long getFriend_id() {
        return friend_id;
    }

    public void setFriend_id(long friend_id) {
        this.friend_id = friend_id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return id == payment.id && friend_id == payment.friend_id && concept.equals(payment.concept) && amount.equals(payment.amount) && date.equals(payment.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, concept, amount, friend_id, date);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", concept='" + concept + '\'' +
                ", amount=" + amount +
                ", friendID=" + friend_id +
                ", date=" + date +
                '}';
    }
}
