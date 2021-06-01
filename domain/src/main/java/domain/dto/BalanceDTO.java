package domain.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class BalanceDTO implements Comparable<BalanceDTO>{
    private final BigDecimal balance;
    private final FriendDTO friend;

    public BalanceDTO(BigDecimal balance, FriendDTO friend) {
        this.balance = balance;
        this.friend = friend;
    }

    public BigDecimal getBalance() { return balance; }

    public FriendDTO getFriend() { return friend; }

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
        BalanceDTO balance1 = (BalanceDTO) o;
        return Objects.equals(balance, balance1.balance) && Objects.equals(friend, balance1.friend);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance, friend);
    }


    @Override
    public int compareTo(BalanceDTO o) {
        return this.balance.compareTo(o.balance);
    }
}
