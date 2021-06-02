package sharedexpenses.app.repository.mappers;

import sharedexpenses.app.repository.mysqlImp.mappers.FriendsGroupMapper;
import sharedexpenses.domain.Friend;
import sharedexpenses.domain.FriendsGroup;
import sharedexpenses.domain.Payment;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


@SpringBootTest
public class FriendsGroupMapperIT {

    @Autowired
    FriendsGroupMapper friendsGroupMapper;

    ////SELECT ALL
    @Test
    public void shouldGetAllGroups(){
        List<FriendsGroup> groups = friendsGroupMapper.findAllGroups();
        MatcherAssert.assertThat(groups.get(0).getName(), is("Prueba1"));
        MatcherAssert.assertThat(groups.get(1).getName(), is("Prueba2"));
    }

    //SELECT BY ID
    @Test
    public void shouldGetGroupById(){
        FriendsGroup group = friendsGroupMapper.findGroupById(1);
        MatcherAssert.assertThat(group.getName(), is("Prueba1"));
    }

    @Test
    public void shouldGetFriendsByGroup(){
        List<Friend> friends = friendsGroupMapper.findFriendsByGroup(1);
        MatcherAssert.assertThat(friends.get(0).getName(), is("Sonia"));
        MatcherAssert.assertThat(friends.get(1).getName(), is("Paco"));
    }

    @Test
    public void shouldGetPaymentByFriend(){
        List<Payment> payments = friendsGroupMapper.findPaymentsByFriend(1);
        MatcherAssert.assertThat(payments.get(0).getConcept(), is("pago prueba 1"));
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
