package com.sharedexpenses.repository;

import com.sharedexpenses.domain.Friend;
import com.sharedexpenses.domain.FriendsGroup;
import com.sharedexpenses.domain.Payment;

import java.util.List;

public interface FriendsGroupRepository {
    List<FriendsGroup> getAllGroups();
    FriendsGroup getGroupById(long id);
    List<Friend> getFriendsByGroup(long groupId);
    List<Payment> getPaymentsByGroup(long groupId);
    FriendsGroup addGroup(FriendsGroup group);
    void deleteGroup(long id);
}
