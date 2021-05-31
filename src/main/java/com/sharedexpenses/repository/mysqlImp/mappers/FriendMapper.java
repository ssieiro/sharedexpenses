package com.sharedexpenses.repository.mysqlImp.mappers;

import com.sharedexpenses.domain.Friend;
import com.sharedexpenses.domain.FriendDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FriendMapper {

    //SELECT ALL
    List findAllFriends();

    //SELECT BY ID
    Friend findFriendById(long id);

    //INSERT
    void insertFriend(FriendDTO friend);

    //DELETE
    void deleteFriendById(long id);

}
