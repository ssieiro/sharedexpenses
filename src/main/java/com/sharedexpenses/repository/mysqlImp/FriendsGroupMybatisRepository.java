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
    List<Friend> findAllFriends();

    @Select("select * from payment")
    List<Payment> findAllPayments();

    //SELECT BY ID
    @Select("SELECT * FROM friends_group WHERE id = #{id}")
    FriendsGroup findGroupById(long id);

    @Select("SELECT * FROM friend WHERE id = #{id}")
    Friend findFriendById(long id);

    @Select("SELECT * FROM payment WHERE id = #{id}")
    Payment findPaymentById(long id);

    @Select ("SELECT * FROM friend WHERE group_id = #{groupId}")
    List<Friend> findFriendsByGroup(long groupId);

    @Select ("SELECT * FROM payment WHERE friend_id = #{friendId}")
    List<Payment> findPaymentsByFriend(long friendId);

    //INSERT
    @Insert("INSERT INTO friends_group(name) " +
            " VALUES (#{name}) ")
    @SelectKey(keyColumn="id", keyProperty="id", resultType=long.class, before=false, statement="select last_insert_id()")
    void insertFriendsGroup(FriendsGroup friendsGroup);

    @Insert("INSERT INTO friend(name, group_id) " +
            " VALUES (#{name}, #{group_id}) ")
    @SelectKey(keyColumn="id", keyProperty="id", resultType=long.class, before=false, statement="select last_insert_id()")
    void insertFriend(Friend friend);

    @Insert("INSERT INTO payment(concept, amount, date, friend_id) " +
            " VALUES (#{concept}, #{amount}, #{date}, #{friend_id})")
    @SelectKey(keyColumn="id", keyProperty="id", resultType=long.class, before=false, statement="select last_insert_id()")
    void insertPayment(Payment payment);

    //DELETE
    @Delete("DELETE FROM friends_group WHERE id = #{id}")
    void deleteGroupById(long id);

    @Delete("DELETE FROM friend WHERE id = #{id}")
    void deleteFriendById(long id);

    @Delete("DELETE FROM payment WHERE id = #{id}")
    void deletePaymentById(long id);
}
