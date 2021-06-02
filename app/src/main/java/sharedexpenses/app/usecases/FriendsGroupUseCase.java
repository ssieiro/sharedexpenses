package sharedexpenses.app.usecases;

import sharedexpenses.domain.*;

import java.util.List;

public interface FriendsGroupUseCase {
    List<FriendsGroup> getAllGroups();
    FriendsGroup getGroupById(long id);
    List<Friend> getFriendsByGroup(long groupId);
    List<Payment> getPaymentsByGroup(long groupId);
    List<Balance> calculateBalance(long groupId);
    List<Debt> calculateDebts(long groupId);
    FriendsGroup addGroup(FriendsGroup group);
    void deleteGroup(long id);
}

