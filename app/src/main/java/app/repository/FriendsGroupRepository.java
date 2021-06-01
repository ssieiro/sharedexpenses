package app.repository;

import domain.Friend;
import domain.FriendsGroup;
import domain.Payment;

import java.util.List;

public interface FriendsGroupRepository {
    List<FriendsGroup> getAllGroups();
    FriendsGroup getGroupById(long id);
    List<Friend> getFriendsByGroup(long groupId);
    List<Payment> getPaymentsByGroup(long groupId);
    FriendsGroup addGroup(FriendsGroup group);
    void deleteGroup(long id);
}
