package sharedexpenses.app.repository.mysqlImp.mappers;


import sharedexpenses.domain.Friend;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FriendMapper {

    //SELECT ALL
    List findAllFriends();

    //SELECT BY ID
    Friend findFriendById(long id);

    //INSERT
    void insertFriend(Friend friend);

    //DELETE
    void deleteFriendById(long id);

}
