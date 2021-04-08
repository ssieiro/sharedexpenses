package com.sharedexpenses.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calculator {

    public static List<Balance> calculateBalance(FriendsGroup friendsGroup) {

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


    private static BigDecimal calculateTotalAmount(List<Payment> payments) {

        List <BigDecimal> amounts = new ArrayList<>();
        payments.forEach(payment -> {
            amounts.add(payment.getAmount());
        });

        return amounts.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
    }


    private static BigDecimal calculateDebtByFriend(Friend friendToCompare, FriendsGroup friendsGroup) {

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
            BigDecimal debt = totalAmount.divide((BigDecimal.valueOf(friendsGroup.getFriendsList().size())), 2, RoundingMode.CEILING)
                    .subtract(friendPayments);
            return debt;
        }
    }
}
