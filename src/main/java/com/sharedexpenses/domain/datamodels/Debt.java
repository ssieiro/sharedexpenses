package com.sharedexpenses.domain.datamodels;

import java.math.BigDecimal;
import java.util.Objects;

public class Debt {
    private final Friend from;
    private final Friend to;
    private final BigDecimal amount;

    public Debt (Friend from, Friend to, BigDecimal amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public Friend getFrom() {
        return from;
    }

    public Friend getTo() {
        return to;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Debt debt = (Debt) o;
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
