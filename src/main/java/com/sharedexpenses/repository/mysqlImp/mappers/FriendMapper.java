package com.sharedexpenses.repository.mysqlImp.mappers;

import com.sharedexpenses.domain.Friend;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FriendMapper {

    //SELECT ALL
    @Select("select * from friend")
    @Results({
            @Result(property = "groupId", column = "group_id")
    })
    List<Friend> findAllFriends();

    //SELECT BY ID
    @Select("SELECT * FROM friend WHERE id = #{id}")
    @Results({
            @Result(property = "groupId", column = "group_id")
    })
    Friend findFriendById(long id);

    //INSERT
    @Insert("INSERT INTO friend(name, group_id) " +
            " VALUES (#{name}, #{groupId}) ")
    @SelectKey(keyColumn="id", keyProperty="id", resultType=long.class, before=false, statement="select last_insert_id()")
    @Results({
            @Result(property = "groupId", column = "group_id")
    })
    void insertFriend(Friend friend);

    //DELETE
    @Delete("DELETE FROM friend WHERE id = #{id}")
    @Results({
            @Result(property = "groupId", column = "group_id")
    })
    void deleteFriendById(long id);

}
