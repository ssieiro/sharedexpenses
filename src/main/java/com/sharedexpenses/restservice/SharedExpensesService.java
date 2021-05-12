package com.sharedexpenses.restservice;

import com.sharedexpenses.domain.datamodels.*;

import java.util.List;

public interface SharedExpensesService {
    public List<FriendsGroup> getAllGroups();
    public List<Friend> getAllFriends();
    public List<Payment> getAllPayments();
    public FriendsGroup getGroupById(int id);
    public List<Friend> getFriendsByGroup(int groupId);
    public List<Payment> getPaymentsByGroup(int groupId);
    public List<Balance> calculateBalance(int groupId);
    public List<Debt> calculateDebts(int groupId);
    public FriendsGroup addGroup(FriendsGroup group);
    public Friend addFriend(Friend friend);
    public Payment addPayment(Payment payment);
}

