package com.sharedexpenses.domain.datamodels;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FriendsGroup {
    private String name;
    private final List<Friend> friendsList = new ArrayList<>();
    private final List<Payment> payments = new ArrayList<>();

    public FriendsGroup(){};
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

    public Friend getFriendByName(String friendName){
        Optional<Friend> opFriend = friendsList.stream().filter(friend -> friend.getName().equals(friendName)).findFirst();
        if (opFriend.isPresent()) {
            Friend friend = opFriend.get();
            return friend;
        } else {
            throw new RuntimeException("Friend not found -"+friendName);
        }
    }

    public void addFriend(String name) {
        Friend friend = new Friend(name);
        friendsList.add(friend);
    }


    public void addPayment(String concept, BigDecimal amount, Friend friend, LocalDateTime date) {
        if (friendsList.contains(friend)){
            Payment payment = new Payment(concept, amount, friend, date);
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
