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
    public List<FriendsGroup> findAllGroups();

    @Select("select * from friend")
    public List<Friend> findAllFriends();

    @Select("select * from payment")
    public List<Payment> findAllPayments();

    //SELECT BY ID
    @Select("SELECT * FROM friends_group WHERE id = #{id}")
    public FriendsGroup findGroupById(long id);

    @Select("SELECT * FROM friend WHERE id = #{id}")
    public Friend findFriendById(long id);

    @Select("SELECT * FROM payment WHERE id = #{id}")
    public Payment findPaymentById(long id);

    @Select ("SELECT * FROM friend WHERE group_id = #{groupId}")
    public List<Friend> getFriends(long groupId);

    @Select ("SELECT * FROM payment WHERE friend_id = #{friendId}")
    public List<Payment> getPayments(long friendId);

    //INSERT
    @Insert("INSERT INTO friends_group(name) " +
            " VALUES (#{name}) ")
    @SelectKey(keyColumn="id", keyProperty="id", resultType=long.class, before=false, statement="select last_insert_id()")
    public void insertFriendsGroup(FriendsGroup friendsGroup);

    @Insert("INSERT INTO friend(name, group_id) " +
            " VALUES (#{name}, #{group_id}) ")
    @SelectKey(keyColumn="id", keyProperty="id", resultType=long.class, before=false, statement="select last_insert_id()")
    public void insertFriend(Friend friend);

    @Insert("INSERT INTO payment(concept, amount, date, friend_id) " +
            " VALUES (#{concept}, #{amount}, #{date}, #{friend_id})")
    @SelectKey(keyColumn="id", keyProperty="id", resultType=long.class, before=false, statement="select last_insert_id()")
    public void insertPayment(Payment payment);

    //DELETE

    @Delete("DELETE FROM friends_group WHERE id = #{id}")
    public void deleteById(long id);

}
