package sharedexpenses.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Balance implements Comparable<Balance>{
    private final BigDecimal balance;
    private final Friend friend;

    public Balance(BigDecimal balance, Friend friend) {
        this.balance = balance;
        this.friend = friend;
    }
    public BigDecimal getBalance() { return balance; }

    public Friend getFriend() { return friend; }

    @Override
    public String toString() {
        return "Balance{" +
                "balance=" + balance +
                ", friend=" + friend +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balance balance1 = (Balance) o;
        return Objects.equals(balance, balance1.balance) && Objects.equals(friend, balance1.friend);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance, friend);
    }


    @Override
    public int compareTo(Balance o) {
        return this.balance.compareTo(o.balance);
    }
}
