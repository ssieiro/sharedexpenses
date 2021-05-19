package com.sharedexpenses.restservice;

import com.sharedexpenses.domain.datamodels.*;
import com.sharedexpenses.repository.SharedExpensesDAO;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class SharedExpensesServiceTests {
    private final SharedExpensesDAO sharedExpensesDAO = mock(SharedExpensesDAO.class);
    private final SharedExpensesService sharedExpensesService = new SharedExpensesServiceImpl(sharedExpensesDAO);
    private final LocalDateTime date = LocalDateTime.now();
    private final FriendsGroup expectedGroup = new FriendsGroup("Grupo1", 1);
    private final List<Friend> expectedFriends = List.of(new Friend("Paco",1, 2));
    private final List<Payment> expectedPayments = List.of(new Payment("pago1", BigDecimal.valueOf(20.0), 2, date));


    @Test
    void shouldGetGroupById() {
        when(sharedExpensesDAO.getGroupById(1)).thenReturn(expectedGroup);
        FriendsGroup group = sharedExpensesService.getGroupById(1);
        assertThat(group, is(expectedGroup));
    }

    @Test
    public void shouldGetAllFriends() {
        when(sharedExpensesDAO.getAllFriends()).thenReturn(expectedFriends);
        List<Friend> friendsList = sharedExpensesService.getAllFriends();
        assertThat(friendsList, is(expectedFriends));
    }

    @Test
    public void shouldAllPayments() {
        when(sharedExpensesDAO.getAllPayments()).thenReturn(expectedPayments);
        List<Payment> paymentsList = sharedExpensesService.getAllPayments();
        assertThat(paymentsList, is(expectedPayments));
    }

    @Test
    public void shouldGetFriendsByGroup() {
        when(sharedExpensesDAO.getFriendsByGroup(1)).thenReturn(expectedFriends);
        List<Friend> friendsList = sharedExpensesService.getFriendsByGroup(1);
        assertThat(friendsList, is(expectedFriends));
    }

    @Test
    public void shouldGetPaymentsByGroup() {
        when(sharedExpensesDAO.getPaymentsByGroup(1)).thenReturn(expectedPayments);
        List<Payment> paymentsList = sharedExpensesService.getPaymentsByGroup(1);
        assertThat(paymentsList, is(expectedPayments));
    }


    @Test
    public void shouldCalculateBalance() {
        List<Balance> expectedBalance = List.of(new Balance(BigDecimal.valueOf(20), new Friend("Paco",1,  2)));
        when(sharedExpensesDAO.calculateBalance(1)).thenReturn(expectedBalance);
        List<Balance> balanceList = sharedExpensesService.calculateBalance(1);
        assertThat(balanceList, is(expectedBalance));
    }

    @Test
    public void shouldCalculateDebts() {
        List<Debt> expectedDebt = List.of(new Debt(new Friend("Paco",1, 2), new Friend("Sonia",1, 1), BigDecimal.valueOf(10)));
        when(sharedExpensesDAO.calculateDebts(1)).thenReturn(expectedDebt);
        List<Debt> debtList = sharedExpensesService.calculateDebts(1);
        assertThat(debtList, is(expectedDebt));
    }


    @Test
    public void shouldAddFriendsGroup() {
        FriendsGroup expectedGroup = new FriendsGroup("Grupo2", 1);
        when(sharedExpensesDAO.addGroup(expectedGroup)).thenReturn(expectedGroup);
        FriendsGroup group = sharedExpensesService.addGroup(expectedGroup);
        assertThat(group, is(expectedGroup));
    }

    @Test
    public void shouldAddFriend() {
        Friend expectedFriend = new Friend("Paco",1,  1);
        when(sharedExpensesDAO.addFriend(expectedFriend)).thenReturn(expectedFriend);
        Friend friend = sharedExpensesService.addFriend(expectedFriend);
        assertThat(friend, is(expectedFriend));
    }

    @Test
    public void shouldAddPayment() {
        Payment expectedPayment = new Payment("pago1", BigDecimal.valueOf(20.0), 1, date);
        when(sharedExpensesDAO.addPayment(expectedPayment)).thenReturn(expectedPayment);
        Payment payment = sharedExpensesDAO.addPayment(expectedPayment);
        assertThat(payment, is(expectedPayment));
    }
}