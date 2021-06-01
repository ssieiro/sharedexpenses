package domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Payment {
    private long id;
    private String concept;
    private BigDecimal amount;
    private Friend friend;
    private LocalDateTime date;

    public Payment(){}

    public Payment(long id, String concept, BigDecimal amount, Friend friend, LocalDateTime date){
        this.id = id;
        this.concept = concept;
        this.amount = amount;
        this.friend = friend;
        this.date = date;
    }

    public long getId() {
        return id;
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

    public Friend getFriend() {
        return friend;
    }

    public void setFriend(Friend friend) {
        this.friend = friend;
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
        return id == payment.id && concept.equals(payment.concept) && amount.equals(payment.amount) && friend.equals(payment.friend) && date.equals(payment.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, concept, amount, friend, date);
    }
}
