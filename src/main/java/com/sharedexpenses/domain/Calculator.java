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
            return totalAmount.divide((BigDecimal.valueOf(friendsGroup.getFriendsList().size())), 2, RoundingMode.CEILING)
                    .subtract(friendPayments);
        }
    }

    public static List<Debt> calculateDebts(FriendsGroup friendsGroup) {
        List<Balance> balanceList = calculateBalance(friendsGroup);

        List<Debt> debtsList = new ArrayList<>();

        while (!balanceList.isEmpty()) {
            balanceList.sort(Collections.reverseOrder());
            Balance firstBalance = balanceList.get(0);
            Balance lastBalance = balanceList.get(balanceList.size()-1);
            BigDecimal firstBalanceAmount = firstBalance.getBalance();
            BigDecimal lastBalanceAmount = lastBalance.getBalance();
            balanceList.remove(firstBalance);
            balanceList.remove(lastBalance);

            Debt debt = new Debt(firstBalance.getFriend(), lastBalance.getFriend(), firstBalanceAmount);
            debtsList.add(debt);
            firstBalance = new Balance(firstBalanceAmount.subtract(firstBalanceAmount), firstBalance.getFriend());
            lastBalance = new Balance(lastBalanceAmount.add(firstBalanceAmount), lastBalance.getFriend());

            if ((firstBalance.getBalance().compareTo(BigDecimal.valueOf(-0.05)) < 0) ||
                    (firstBalance.getBalance().compareTo(BigDecimal.valueOf(0.05)) > 0)) {
               balanceList.add(firstBalance);
            }
            if ((lastBalance.getBalance().compareTo(BigDecimal.valueOf(-0.05)) < 0) ||
                    (lastBalance.getBalance().compareTo(BigDecimal.valueOf(0.05)) > 0)) {
                balanceList.add(lastBalance);
            }
        }

        return debtsList;
    }
}
