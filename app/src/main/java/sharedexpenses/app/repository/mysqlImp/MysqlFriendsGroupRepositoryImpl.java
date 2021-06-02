package sharedexpenses.app.repository.mysqlImp;

import sharedexpenses.app.repository.FriendsGroupRepository;
import sharedexpenses.app.repository.mysqlImp.mappers.FriendsGroupMapper;
import sharedexpenses.domain.Friend;
import sharedexpenses.domain.FriendsGroup;
import sharedexpenses.domain.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MysqlFriendsGroupRepositoryImpl implements FriendsGroupRepository {

    private final FriendsGroupMapper friendsGroupMapper;

    @Autowired
    public MysqlFriendsGroupRepositoryImpl(FriendsGroupMapper friendsGroupMapper){
        this.friendsGroupMapper = friendsGroupMapper;
    }

    //GET ALL
    @Override
    public List<FriendsGroup> getAllGroups() { return friendsGroupMapper.findAllGroups(); }

    //GET BY ID
    @Override
    public FriendsGroup getGroupById(long id) { return friendsGroupMapper.findGroupById(id); }

    @Override
    public List<Friend> getFriendsByGroup(long groupId) { return friendsGroupMapper.findFriendsByGroup(groupId); }

    @Override
    public List<Payment> getPaymentsByGroup(long groupId) {
        List<Friend> friends = getFriendsByGroup(groupId);
        List<Payment> payments = new ArrayList<>();
        friends.forEach(friend -> {
            List<Payment> friendPayments = friendsGroupMapper.findPaymentsByFriend(friend.getId());
            payments.addAll(friendPayments);
        });
        return payments;}

    //ADD
    @Override
    public FriendsGroup addGroup(FriendsGroup group) {
        friendsGroupMapper.insertFriendsGroup(group);
        return friendsGroupMapper.findGroupById(group.getId());
    }

    //DELETE
    @Override
    public void deleteGroup(long id) { friendsGroupMapper.deleteGroupById(id); }

}
