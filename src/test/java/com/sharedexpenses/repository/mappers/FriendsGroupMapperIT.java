package com.sharedexpenses.repository.mappers;

import com.sharedexpenses.domain.*;
import com.sharedexpenses.repository.mysqlImp.mappers.FriendsGroupMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/*
@SpringBootTest
public class FriendsGroupMapperIT {

    @Autowired
    FriendsGroupMapper friendsGroupMapper;

    ////SELECT ALL
    @Test
    public void shouldGetAllGroups(){
        List<FriendsGroup> groups = friendsGroupMapper.findAllGroups();
        assertThat(groups.get(0).getName(), is("Prueba1"));
        assertThat(groups.get(1).getName(), is("Prueba2"));
    }

    //SELECT BY ID
    @Test
    public void shouldGetGroupById(){
        FriendsGroup group = friendsGroupMapper.findGroupById(1);
        assertThat(group.getName(), is("Prueba1"));
    }

    @Test
    public void shouldGetFriendsByGroup(){
        List<Friend> friends = friendsGroupMapper.findFriendsByGroup(1);
        assertThat(friends.get(0).getName(), is("Sonia"));
        assertThat(friends.get(1).getName(), is("Paco"));
    }

    @Test
    public void shouldGetPaymentByFriend(){
        List<Payment> payments = friendsGroupMapper.findPaymentsByFriend(1);
        assertThat(payments.get(0).getConcept(), is("pago prueba 1"));
    }

    //INSERT AND DELETE
    @Test
    public void shouldInsertAndDeleteGroup(){
        friendsGroupMapper.insertFriendsGroup(new FriendsGroup("Grupo test"));
        List<FriendsGroup> groupsAfterInsert = friendsGroupMapper.findAllGroups();
        assertThat(groupsAfterInsert.size(), is(3));
        friendsGroupMapper.deleteGroupById(3);
        List<FriendsGroup> groupsAfterDelete = friendsGroupMapper.findAllGroups();
        assertThat(groupsAfterDelete.size(), is(2));
    }

}
*/