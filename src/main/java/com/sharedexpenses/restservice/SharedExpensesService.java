package com.sharedexpenses.restservice;

import com.sharedexpenses.domain.datamodels.*;

import java.util.List;

public interface SharedExpensesService {
    public List<FriendsGroup> getAllGroups();
    public List<Friend> getAllFriends();
    public List<Payment> getAllPayments();
    public FriendsGroup getGroupById(long id);
    public List<Friend> getFriendsByGroup(long groupId);
    public List<Payment> getPaymentsByGroup(long groupId);
    public List<Balance> calculateBalance(long groupId);
    public List<Debt> calculateDebts(long groupId);
    public FriendsGroup addGroup(FriendsGroup group);
    public Friend addFriend(Friend friend);
    public Payment addPayment(Payment payment);
}

