package com.sharedexpenses.repository.mysqlImp;

import com.sharedexpenses.domain.Friend;
import com.sharedexpenses.repository.FriendRepository;
import com.sharedexpenses.repository.mysqlImp.mappers.FriendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MysqlFriendRepositoryImpl implements FriendRepository {

    private final FriendMapper friendMapper;

    @Autowired
    public MysqlFriendRepositoryImpl(FriendMapper friendMapper){
        this.friendMapper = friendMapper;
    }

    //GET ALL
    @Override
    public List<Friend> getAllFriends() { return friendMapper.findAllFriends(); }

    //ADD
    @Override
    public Friend addFriend(Friend friend) {
        friendMapper.insertFriend(friend);
        return friendMapper.findFriendById(friend.getId());
    }

    //DELETE
    @Override
    public void deleteFriend(long id) { friendMapper.deleteFriendById(id);}
}
