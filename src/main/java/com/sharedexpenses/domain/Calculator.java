package com.sharedexpenses.domain;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class DebtsCalculator{

    public static List<Debt> calculateDebts(FriendsGroup friendsGroup) {
        return Collections.emptyList();
    }
    /*

    public static BigDecimal calculateTotalAmount(List<Payment> payments) {
        BigDecimal sum = payments.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        return sum;
    }



    public double calculateDebtByFriend(Friend friendToCompare) {
        double totalAmount = calculateTotalAmount();
        int friendToCompareId = friendToCompare.getFriendId();
        List<Payment> paymentsByFriend = new ArrayList<>();
        payments.forEach(payment -> {
            if (payment.getPayer().getFriendId() == friendToCompareId) {
                paymentsByFriend.add(payment);
            }
        });

        double friendPayments = paymentsByFriend.stream().mapToDouble(Payment::getAmount).sum();
        double debt = (totalAmount/friendsList.size()) - friendPayments;
        return debt;
    }

    public void printTotalDebts(){
        System.out.println("Grupo: " + this.name);
        friendsList.forEach(friend -> {
            System.out.println(friend.getName() + ": " + calculateDebtByFriend(friend) );
        });
    }*/

}
