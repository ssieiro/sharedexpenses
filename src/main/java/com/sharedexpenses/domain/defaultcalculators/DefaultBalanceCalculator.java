package com.sharedexpenses.domain.defaultcalculators;

import com.sharedexpenses.domain.BalanceCalculator;
import com.sharedexpenses.domain.datamodels.Balance;
import com.sharedexpenses.domain.datamodels.Friend;
import com.sharedexpenses.domain.datamodels.FriendsGroup;
import com.sharedexpenses.domain.datamodels.Payment;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class DefaultBalanceCalculator implements BalanceCalculator {
    public List<Balance> calculateBalance(FriendsGroup friendsGroup) {

        if (friendsGroup.getFriendsList().isEmpty()) {
            return Collections.emptyList();
        }

        else {
            List<Balance> balance = new ArrayList<>();
            friendsGroup.getFriendsList().forEach(friend -> {
                Balance friendBalance = new Balance(calculateDebtByFriend(friend, friendsGroup), friend);
                balance.add(friendBalance);
            });
            return balance;
        }
    }

    private BigDecimal calculateTotalAmount(List<Payment> payments) {

        List <BigDecimal> amounts = new ArrayList<>();
        payments.forEach(payment -> {
            amounts.add(payment.getAmount());
        });

        return amounts.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
    }


    private BigDecimal calculateDebtByFriend(Friend friendToCompare, FriendsGroup friendsGroup) {

        if (friendsGroup.getPayments().isEmpty()){
            return BigDecimal.valueOf(0).setScale(2);
        }

        else {
            BigDecimal totalAmount = calculateTotalAmount(friendsGroup.getPayments());

            String friendToCompareName = friendToCompare.getName();
            List<BigDecimal> paymentsByFriend = new ArrayList<>();

            friendsGroup.getPayments().forEach(payment -> {
                if (payment.getPayer().getName().equals(friendToCompareName)) {
                    paymentsByFriend.add(payment.getAmount());
                }
            });

            BigDecimal friendPayments = paymentsByFriend.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
            return totalAmount.divide((BigDecimal.valueOf(friendsGroup.getFriendsList().size())), 2, RoundingMode.CEILING)
                    .subtract(friendPayments);
        }
    }
}
