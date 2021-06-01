package domain.defaultcalculators;

import domain.BalanceCalculator;
import domain.Balance;
import domain.Friend;
import domain.Payment;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class DefaultBalanceCalculator implements BalanceCalculator {
    public List<Balance> calculateBalance(List<Payment> payments, List<Friend> friends) {
        if (friends.isEmpty()) {
            return Collections.emptyList();
        } else {
            List<Balance> balance = new ArrayList<>();
            friends.forEach(friend -> {
                Balance friendBalance = new Balance(calculateDebtByFriend(friend, payments, friends), friend);
                balance.add(friendBalance);
            });
            return balance;
        }
    }

    private BigDecimal calculateTotalAmount(List<Payment> payments) {
        return payments.stream().map(Payment::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calculateDebtByFriend(Friend friendToCompare, List<Payment> payments, List<Friend> friends) {
        if (payments.isEmpty()) {
            return BigDecimal.valueOf(0).setScale(2);
        } else {
            BigDecimal totalAmount = calculateTotalAmount(payments);
            long friendToCompareId = friendToCompare.getId();
            List<BigDecimal> paymentsByFriend = new ArrayList<>();

            payments.forEach(payment -> {
                if (payment.getFriend().getId() == friendToCompareId) {
                    paymentsByFriend.add(payment.getAmount());
                }
            });

            BigDecimal friendPayments = paymentsByFriend.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
            return totalAmount.divide((BigDecimal.valueOf(friends.size())), 2, RoundingMode.CEILING)
                    .subtract(friendPayments);
        }
    }
}

