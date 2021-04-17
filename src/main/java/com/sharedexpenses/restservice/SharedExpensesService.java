package com.sharedexpenses.restservice;

import com.sharedexpenses.domain.datamodels.*;

import java.util.List;
import java.util.Optional;

public interface SharedExpensesService {
    public List<FriendsGroup> getAllGroups();
    public Optional<FriendsGroup> getGroupByName(String groupName);
    public List<Friend> getFriends(FriendsGroup group);
    public List<Payment> getPayments(FriendsGroup group);
    public List<Balance> calculateBalance(FriendsGroup friendsGroup);
    public List<Debt> calculateDebts(FriendsGroup friendsGroup);
    public FriendsGroup addGroup(FriendsGroup group);
    public Friend addFriend(FriendsGroup group, Friend friend);
    public Payment addPayment(FriendsGroup group, Payment payment);
}

