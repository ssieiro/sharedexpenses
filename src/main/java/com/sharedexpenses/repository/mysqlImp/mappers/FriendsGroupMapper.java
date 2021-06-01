package com.sharedexpenses.repository.mysqlImp.mappers;

import com.sharedexpenses.domain.FriendsGroup;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FriendsGroupMapper {

    //SELECT ALL
    List findAllGroups();

    //SELECT BY ID
    FriendsGroup findGroupById(long id);

    List findFriendsByGroup(long groupId);

    List findPaymentsByFriend(long friendId);

    //INSERT
    void insertFriendsGroup(FriendsGroup friendsGroup);

    //DELETE
    void deleteGroupById(long id);

}
