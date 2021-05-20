package com.sharedexpenses.repository.mysqlImp.mappers;

import com.sharedexpenses.domain.Friend;
import com.sharedexpenses.domain.FriendsGroup;
import com.sharedexpenses.domain.Payment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FriendsGroupMapper {

    //SELECT ALL
    @Select("select * from friends_group")
    List<FriendsGroup> findAllGroups();

    //SELECT BY ID
    @Select("SELECT * FROM friends_group WHERE id = #{id}")
    FriendsGroup findGroupById(long id);

    @Select ("SELECT * FROM friend WHERE group_id = #{groupId}")
    @Results({
            @Result(property = "groupId", column = "group_id")
    })
    List<Friend> findFriendsByGroup(long groupId);

    @Select ("SELECT * FROM payment WHERE friend_id = #{friendId}")
    @Results({
            @Result(property = "friendId", column = "friend_id")
    })
    List<Payment> findPaymentsByFriend(long friendId);

    //INSERT
    @Insert("INSERT INTO friends_group(name) " +
            " VALUES (#{name}) ")
    @SelectKey(keyColumn="id", keyProperty="id", resultType=long.class, before=false, statement="select last_insert_id()")
    void insertFriendsGroup(FriendsGroup friendsGroup);

    //DELETE
    @Delete("DELETE FROM friends_group WHERE id = #{id}")
    void deleteGroupById(long id);

}
