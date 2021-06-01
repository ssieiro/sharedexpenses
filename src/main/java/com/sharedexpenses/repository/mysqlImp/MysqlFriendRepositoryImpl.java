package com.sharedexpenses.repository.mysqlImp;

import com.sharedexpenses.domain.Friend;
import com.sharedexpenses.domain.dto.FriendDTO;
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

    //GET BY ID
    @Override
    public Friend getFriendById(long friendId) { return friendMapper.findFriendById(friendId); }

    //ADD
    @Override
    public Friend addFriend(FriendDTO friend) {
        friendMapper.insertFriend(friend);
        return getFriendById(friend.getId());
    }

    //DELETE
    @Override
    public void deleteFriend(long id) { friendMapper.deleteFriendById(id);}
}
