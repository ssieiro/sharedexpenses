package com.sharedexpenses.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FriendsGroup {
    private final String name;
    private final List<Friend> friendsList = new ArrayList<>();
    private final List<Payment> payments = new ArrayList<>();


    public FriendsGroup(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Friend> getFriendsList() {
        return friendsList;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void addFriend(String name) {
        Friend friend = new Friend(name);
        friendsList.add(friend);
    }


    public void addPayment(String concept, BigDecimal amount, String payerName, LocalDateTime date) {
        Optional<Friend> payer = friendsList.stream().filter(friend -> friend.getName().equals(payerName)).findFirst();
        if (payer.isPresent()) {
            Payment payment = new Payment(concept, amount, payer.get(), date);
            payments.add(payment);
        }
    }
}

/*    public void removePayment(String concept) {
        payments.removeIf(payment -> payment.getConcept().equals(concept));
    }

}
       public void removeFriend(String name) {
        friendsList.removeIf(friend -> friend.getName().equals(name));
    }
 */
