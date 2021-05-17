package com.sharedexpenses.repository;

import com.sharedexpenses.domain.BalanceCalculator;
import com.sharedexpenses.domain.DebtCalculator;
import com.sharedexpenses.domain.datamodels.Friend;
import com.sharedexpenses.domain.datamodels.FriendsGroup;
import com.sharedexpenses.domain.datamodels.Payment;
import com.sharedexpenses.repository.mysqlImp.FriendsGroupMybatisRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
public class MysqlDAOIT {


    @Autowired
    FriendsGroupMybatisRepository repository;

    @Autowired
    BalanceCalculator balanceCalculator;

    @Autowired
    DebtCalculator debtCalculator;

    ////SELECT ALL
    @Test
    public void shouldGetAllGroups(){
        List<FriendsGroup> groups = repository.findAllGroups();
        assertThat(groups.get(0).getName(), is("Prueba1"));
        assertThat(groups.get(1).getName(), is("Prueba2"));
    }

    @Test
    public void shouldGetAllFriends(){
        List<Friend> friends = repository.findAllFriends();
        assertThat(friends.get(0).getName(), is("Sonia"));
        assertThat(friends.get(1).getName(), is("Paco"));
        assertThat(friends.get(2).getName(), is("Sonia"));
        assertThat(friends.get(3).getName(), is("Paco"));
        assertThat(friends.get(4).getName(), is("Alba"));
    }

    @Test
    public void shouldGetAllPayments(){
        List<Payment> payments = repository.findAllPayments();
        assertThat(payments.get(0).getConcept(), is("pago prueba 1"));
        assertThat(payments.get(1).getConcept(), is("pago prueba 2"));
    }

    //SELECT BY ID
    @Test
    public void shouldGetGroupById(){
        FriendsGroup group = repository.findGroupById(1);
        assertThat(group.getName(), is("Prueba1"));
    }

    @Test
    public void shouldGetFriendById(){
        Friend friend = repository.findFriendById(1);
        assertThat(friend.getName(), is("Sonia"));
    }

    @Test
    public void shouldGetPaymentById(){
        Payment payment = repository.findPaymentById(1);
        assertThat(payment.getConcept(), is("pago prueba 1"));
    }

    @Test
    public void shouldGetFriendsByGroup(){
        List<Friend> friends = repository.findFriendsByGroup(1);
        assertThat(friends.get(0).getName(), is("Sonia"));
        assertThat(friends.get(1).getName(), is("Paco"));
    }

    @Test
    public void shouldGetPaymentByFriend(){
        List<Payment> payments = repository.findPaymentsByFriend(1);
        assertThat(payments.get(0).getConcept(), is("pago prueba 1"));
    }

    //INSERT AND DELETE

    @Test
    public void shouldInsertAndDeleteGroup(){
        repository.insertFriendsGroup(new FriendsGroup("Grupo test"));
        List<FriendsGroup> groupsAfterInsert = repository.findAllGroups();
        assertThat(groupsAfterInsert.size(), is(3));
        repository.deleteGroupById(3);
        List<FriendsGroup> groupsAfterDelete = repository.findAllGroups();
        assertThat(groupsAfterDelete.size(), is(2));
    }

    @Test
    public void shouldInsertAndDeleteFriend(){
        repository.insertFriend(new Friend("Friend test", 1, 1));
        List<Friend> friendsAfterInsert = repository.findAllFriends();
        assertThat(friendsAfterInsert.size(), is(6));
        repository.deleteFriendById(6);
        List<Friend> friendsAfterDelete = repository.findAllFriends();
        assertThat(friendsAfterDelete.size(), is(5));
    }

    @Test
    public void shouldInsertAndDeletePayment(){
        repository.insertPayment(new Payment("Payment test", BigDecimal.valueOf(20), 1, LocalDateTime.now()));
        List<Payment> paymentssAfterInsert = repository.findAllPayments();
        assertThat(paymentssAfterInsert.size(), is(3));
        repository.deletePaymentById(3);
        List<Payment> paymentsAfteDelete = repository.findAllPayments();
        assertThat(paymentsAfteDelete.size(), is(2));
    }

}
