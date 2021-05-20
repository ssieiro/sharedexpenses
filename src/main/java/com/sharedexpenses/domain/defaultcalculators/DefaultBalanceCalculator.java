package com.sharedexpenses.domain.defaultcalculators;

import com.sharedexpenses.domain.BalanceCalculator;
import com.sharedexpenses.domain.Balance;
import com.sharedexpenses.domain.Friend;
import com.sharedexpenses.domain.Payment;
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
        List<BigDecimal> amounts = new ArrayList<>();
        payments.forEach(payment -> {
            amounts.add(payment.getAmount());
        });
        return amounts.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calculateDebtByFriend(Friend friendToCompare, List<Payment> payments, List<Friend> friends) {
        if (payments.isEmpty()) {
            return BigDecimal.valueOf(0).setScale(2);
        } else {
            BigDecimal totalAmount = calculateTotalAmount(payments);
            long friendToCompareId = friendToCompare.getId();
            List<BigDecimal> paymentsByFriend = new ArrayList<>();

            payments.forEach(payment -> {
                if (payment.getFriendId() == friendToCompareId) {
                    paymentsByFriend.add(payment.getAmount());
                }
            });

            BigDecimal friendPayments = paymentsByFriend.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
            return totalAmount.divide((BigDecimal.valueOf(friends.size())), 2, RoundingMode.CEILING)
                    .subtract(friendPayments);
        }
    }
}

