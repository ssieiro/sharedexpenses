package com.sharedexpenses.controller;

import com.sharedexpenses.domain.datamodels.*;
import com.sharedexpenses.restservice.SharedExpensesService;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class SharedExpensesControllerTest {
    private final SharedExpensesService sharedExpensesService = mock(SharedExpensesService.class);
    private final SharedExpensesController sharedExpensesController = new SharedExpensesController(sharedExpensesService);
    private final LocalDateTime date = LocalDateTime.now();
    private final FriendsGroup expectedGroup = new FriendsGroup("Grupo1", 1);
    private final List<Friend> expectedFriends = List.of(new Friend("Paco", 1, 2));
    private final List<Payment> expectedPayments = List.of(new Payment("pago1", BigDecimal.valueOf(20.0), 2, date));


    @Test
    public void shouldGetGroup() {
        when(sharedExpensesService.getGroupById(1)).thenReturn(expectedGroup);
        FriendsGroup group = sharedExpensesController.getGroupById(1);
        assertThat(group, is(expectedGroup));
    }

    @Test
    public void shouldGetAllFriends() {
        when(sharedExpensesService.getAllFriends()).thenReturn(expectedFriends);
        List<Friend> friendsList = sharedExpensesController.getAllFriends();
        assertThat(friendsList, is(expectedFriends));
    }

    @Test
    public void shouldGetAllPayments() {
        when(sharedExpensesService.getAllPayments()).thenReturn(expectedPayments);
        List<Payment> paymentsList = sharedExpensesController.getAllPayments();
        assertThat(paymentsList, is(expectedPayments));
    }

    @Test
    public void shouldGetFriendsByGroup() {
        when(sharedExpensesService.getFriendsByGroup(1)).thenReturn(expectedFriends);
        List<Friend> friendsList = sharedExpensesController.getFriendsByGroup(1);
        assertThat(friendsList, is(expectedFriends));
    }

    @Test
    public void shouldGetPaymentsByGroup() {
        List<Payment> expectedPayments = List.of(new Payment("pago1", BigDecimal.valueOf(20.0), 2, date));
        when(sharedExpensesService.getPaymentsByGroup(1)).thenReturn(expectedPayments);
        List<Payment> paymentsList = sharedExpensesController.getPaymentsByGroup(1);
        assertThat(paymentsList, is(expectedPayments));
    }

    @Test
    public void shouldCalculateBalance() {
        List<Balance> expectedBalance = List.of(new Balance(BigDecimal.valueOf(20), new Friend("Paco", 1, 2)));
        when(sharedExpensesService.calculateBalance(1)).thenReturn(expectedBalance);
        List<Balance> balanceList = sharedExpensesController.calculateBalance(1);
        assertThat(balanceList, is(expectedBalance));
    }

    @Test
    public void shouldCalculateDebts() {
        List<Debt> expectedDebt = List.of(new Debt(new Friend("Paco", 2, 1), new Friend("Sonia", 1, 1), BigDecimal.valueOf(10)));
        when(sharedExpensesService.calculateDebts(1)).thenReturn(expectedDebt);
        List<Debt> debtList = sharedExpensesController.calculateDebts(1);
        assertThat(debtList, is(expectedDebt));
    }

    @Test
    public void shouldAddFriendsGroup(){
        when(sharedExpensesService.addGroup(expectedGroup)).thenReturn(expectedGroup);
        FriendsGroup group = sharedExpensesController.addGroup(expectedGroup);
        assertThat(group, is(expectedGroup));
    }

    @Test
    public void shouldAddFriend(){
        Friend expectedFriend = new Friend("Paco", 1, 1);
        when(sharedExpensesService.addFriend(expectedFriend)).thenReturn(expectedFriend);
        Friend friend = sharedExpensesController.addFriend(expectedFriend);
        assertThat(friend, is(expectedFriend));
    }

    @Test
    public void shouldAddPayment(){
        Payment expectedPayment = new Payment("pago1", BigDecimal.valueOf(20.0), 1, date);
        when(sharedExpensesService.addPayment(expectedPayment)).thenReturn(expectedPayment);
        Payment payment = sharedExpensesController.addPayment(expectedPayment);
        assertThat(payment, is(expectedPayment));
        }
    }