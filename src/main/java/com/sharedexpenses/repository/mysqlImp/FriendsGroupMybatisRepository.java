package com.sharedexpenses.repository.mysqlImp;

import com.sharedexpenses.domain.datamodels.Friend;
import com.sharedexpenses.domain.datamodels.FriendsGroup;
import com.sharedexpenses.domain.datamodels.Payment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FriendsGroupMybatisRepository{

    //SELECT ALL
    @Select("select * from friends_group")
    List<FriendsGroup> findAllGroups();

    @Select("select * from friend")
    @Results({
            @Result(property = "groupId", column = "group_id")
    })
    List<Friend> findAllFriends();

    @Select("select * from payment")
    @Results({
            @Result(property = "friendId", column = "friend_id")
    })
    List<Payment> findAllPayments();

    //SELECT BY ID
    @Select("SELECT * FROM friends_group WHERE id = #{id}")
    FriendsGroup findGroupById(long id);

    @Select("SELECT * FROM friend WHERE id = #{id}")
    @Results({
            @Result(property = "groupId", column = "group_id")
    })
    Friend findFriendById(long id);

    @Select("SELECT * FROM payment WHERE id = #{id}")
    @Results({
            @Result(property = "friendId", column = "friend_id")
    })
    Payment findPaymentById(long id);

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

    @Insert("INSERT INTO friend(name, group_id) " +
            " VALUES (#{name}, #{groupId}) ")
    @SelectKey(keyColumn="id", keyProperty="id", resultType=long.class, before=false, statement="select last_insert_id()")
    @Results({
            @Result(property = "groupId", column = "group_id")
    })
    void insertFriend(Friend friend);

    @Insert("INSERT INTO payment(concept, amount, date, friend_id) " +
            " VALUES (#{concept}, #{amount}, #{date}, #{friendId})")
    @SelectKey(keyColumn="id", keyProperty="id", resultType=long.class, before=false, statement="select last_insert_id()")
    @Results({
            @Result(property = "friendId", column = "friend_id")
    })
    void insertPayment(Payment payment);

    //DELETE
    @Delete("DELETE FROM friends_group WHERE id = #{id}")
    void deleteGroupById(long id);

    @Delete("DELETE FROM friend WHERE id = #{id}")
    @Results({
            @Result(property = "groupId", column = "group_id")
    })
    void deleteFriendById(long id);

    @Delete("DELETE FROM payment WHERE id = #{id}")
    @Results({
            @Result(property = "friendId", column = "friend_id")
    })
    void deletePaymentById(long id);
}
