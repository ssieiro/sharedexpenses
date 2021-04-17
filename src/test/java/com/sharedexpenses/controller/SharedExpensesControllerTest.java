package com.sharedexpenses.controller;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import com.sharedexpenses.domain.datamodels.*;
import com.sharedexpenses.restservice.SharedExpensesService;
import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class SharedExpensesControllerTest {
    private final SharedExpensesService sharedExpensesService = mock(SharedExpensesService.class);
    private final SharedExpensesController sharedExpensesController = new SharedExpensesController(sharedExpensesService);
    private final FriendsGroup expectedGroup = new FriendsGroup("Grupo1");
    private final LocalDateTime date = LocalDateTime.now();

    public void returnGroup(){
        when(sharedExpensesService.getGroupByName("Grupo1")).thenReturn(Optional.of(expectedGroup));
    }

    @Test
    public void shouldGetGroup(){
        returnGroup();
        FriendsGroup group = sharedExpensesController.getGroupByName(expectedGroup.getName());
        assertThat(group, is(expectedGroup));
    }

    @Test
    public void shouldGetFriends(){
        List<Friend> expectedFriends = List.of(new Friend("Paco"));
        returnGroup();
        when(sharedExpensesService.getFriends(expectedGroup)).thenReturn(expectedFriends);
        List<Friend> friendsList = sharedExpensesController.getFriends("Grupo1");
        assertThat(friendsList, is(expectedFriends));
    }

    @Test
    public void shouldGetPayments(){
        List<Payment> expectedPayments = List.of(new Payment("pago1", BigDecimal.valueOf(20.0), new Friend("Paco"), date));
        returnGroup();
        when(sharedExpensesService.getPayments(expectedGroup)).thenReturn(expectedPayments);
        List<Payment> paymentsList = sharedExpensesController.getPayments("Grupo1");
        assertThat(paymentsList, is(expectedPayments));
    }

    @Test
    public void shouldCalculateBalance(){
        List<Balance> expectedBalance = List.of(new Balance(BigDecimal.valueOf(20), new Friend("Paco")));
        returnGroup();
        when(sharedExpensesService.calculateBalance(expectedGroup)).thenReturn(expectedBalance);
        List<Balance> balanceList = sharedExpensesController.calculateBalance("Grupo1");
        assertThat(balanceList, is(expectedBalance));
    }

    @Test
    public void shouldCalculateDebts(){
        List<Debt> expectedDebt = List.of(new Debt(new Friend("Paco"), new Friend("Sonia"), BigDecimal.valueOf(10)));
        returnGroup();
        when(sharedExpensesService.calculateDebts(expectedGroup)).thenReturn(expectedDebt);
        List<Debt> debtList = sharedExpensesController.calculateDebts("Grupo1");
        assertThat(debtList, is(expectedDebt));
    }

    @Test
    public void shouldAddFriendsGroup(){
        FriendsGroup expectedGroup = new FriendsGroup("Grupo2");
        when(sharedExpensesService.addGroup(expectedGroup)).thenReturn(expectedGroup);
        FriendsGroup group = sharedExpensesController.addGroup(expectedGroup);
        assertThat(group, is(expectedGroup));
    }

    @Test
    public void shouldAddFriend(){
        Friend expectedFriend = new Friend("Paco");
        returnGroup();
        when(sharedExpensesService.addFriend(expectedGroup, expectedFriend)).thenReturn(expectedFriend);
        Friend friend = sharedExpensesController.addFriend("Grupo1", expectedFriend);
        assertThat(friend, is(expectedFriend));
    }

    @Test
    public void shouldAddPayment(){
        Payment expectedPayment = new Payment("pago1", BigDecimal.valueOf(20.0), new Friend("Paco"), date);
        returnGroup();
        when(sharedExpensesService.addPayment(expectedGroup, expectedPayment)).thenReturn(expectedPayment);
        Payment payment = sharedExpensesController.addPayment("Grupo1", expectedPayment);
        assertThat(payment, is(expectedPayment));
    }



}