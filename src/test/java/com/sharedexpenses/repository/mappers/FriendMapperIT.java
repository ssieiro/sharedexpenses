package com.sharedexpenses.repository.mappers;

import com.sharedexpenses.domain.*;
import com.sharedexpenses.repository.mysqlImp.mappers.FriendMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/*
@SpringBootTest
public class FriendMapperIT {

    @Autowired
    FriendMapper friendMapper;

    ////SELECT ALL
    @Test
    public void shouldGetAllFriends(){
        List<Friend> friends = friendMapper.findAllFriends();
        assertThat(friends.get(0).getName(), is("Sonia"));
        assertThat(friends.get(1).getName(), is("Paco"));
        assertThat(friends.get(2).getName(), is("Sonia"));
        assertThat(friends.get(3).getName(), is("Paco"));
        assertThat(friends.get(4).getName(), is("Alba"));
    }

    //SELECT BY ID
    @Test
    public void shouldGetFriendById(){
        Friend friend = friendMapper.findFriendById(1);
        assertThat(friend.getName(), is("Sonia"));
    }

    //INSERT AND DELETE
    @Test
    public void shouldInsertAndDeleteFriend(){
        friendMapper.insertFriend(new Friend("Friend test", 1, 1));
        List<Friend> friendsAfterInsert = friendMapper.findAllFriends();
        assertThat(friendsAfterInsert.size(), is(6));
        friendMapper.deleteFriendById(6);
        List<Friend> friendsAfterDelete = friendMapper.findAllFriends();
        assertThat(friendsAfterDelete.size(), is(5));
    }

}*/
