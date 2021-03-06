package sharedexpenses.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class PaymentDTO {
    private long id;
    private String concept;
    private BigDecimal amount;
    private long friendId;
    private LocalDateTime date;

    public PaymentDTO(){}

    public PaymentDTO(long id, String concept, BigDecimal amount, long friendId, LocalDateTime date){
        this.id = id;
        this.concept = concept;
        this.amount = amount;
        this.friendId = friendId;
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

    public long getFriendId() {
        return friendId;
    }

    public void setFriendId(long friendId) {
        this.friendId = friendId;
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
        PaymentDTO payment = (PaymentDTO) o;
        return id == payment.id && friendId == payment.friendId && concept.equals(payment.concept) && amount.equals(payment.amount) && date.equals(payment.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, concept, amount, friendId, date);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", concept='" + concept + '\'' +
                ", amount=" + amount +
                ", friendID=" + friendId +
                ", date=" + date +
                '}';
    }
}
