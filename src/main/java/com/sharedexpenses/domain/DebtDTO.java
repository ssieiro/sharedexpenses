package com.sharedexpenses.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class DebtDTO {
    private final FriendDTO from;
    private final FriendDTO to;
    private final BigDecimal amount;

    public DebtDTO(FriendDTO from, FriendDTO to, BigDecimal amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public FriendDTO getFrom() {
        return from;
    }

    public FriendDTO getTo() {
        return to;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DebtDTO debt = (DebtDTO) o;
        return from.equals(debt.from) && to.equals(debt.to) && amount.equals(debt.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, amount);
    }

    @Override
    public String toString() {
        return "Debt{" +
                "from=" + from +
                ", to=" + to +
                ", amount=" + amount +
                '}';
    }
}
