package com.sharedexpenses.restservice;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import com.sharedexpenses.domain.datamodels.*;
import com.sharedexpenses.repository.SharedExpensesDAO;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SharedExpensesServiceTests {
    private final SharedExpensesDAO sharedExpensesDAO = mock(SharedExpensesDAO.class);
    private final SharedExpensesService sharedExpensesService = new SharedExpensesServiceImpl(sharedExpensesDAO);
    private final FriendsGroup expectedGroup = new FriendsGroup("Grupo1");
    private final LocalDateTime date = LocalDateTime.now();

    @Test void shouldGetGroup(){
        when(sharedExpensesDAO.getGroupByName("Grupo1")).thenReturn(Optional.of(expectedGroup));
        Optional<FriendsGroup> group = sharedExpensesService.getGroupByName("Grupo1");
        assertThat(group, is(Optional.of(expectedGroup)));
    }

    @Test
    public void shouldGetFriends(){
        List<Friend> expectedFriends = List.of(new Friend("Paco"));
        when(sharedExpensesDAO.getFriends(expectedGroup)).thenReturn(expectedFriends);
        List<Friend> friendsList = sharedExpensesService.getFriends(expectedGroup);
        assertThat(friendsList, is(expectedFriends));
    }

    @Test
    public void shouldGetPayments(){
        List<Payment> expectedPayments = List.of(new Payment("pago1", BigDecimal.valueOf(20.0), new Friend("Paco"), date));
        when(sharedExpensesDAO.getPayments(expectedGroup)).thenReturn(expectedPayments);
        List<Payment> paymentsList = sharedExpensesService.getPayments(expectedGroup);
        assertThat(paymentsList, is(expectedPayments));
    }

    @Test
    public void shouldCalculateBalance() {
        List<Balance> expectedBalance = List.of(new Balance(BigDecimal.valueOf(20), new Friend("Paco")));
        when(sharedExpensesDAO.calculateBalance(expectedGroup)).thenReturn(expectedBalance);
        List<Balance> balanceList = sharedExpensesService.calculateBalance(expectedGroup);
        assertThat(balanceList, is(expectedBalance));
    }

    @Test
    public void shouldCalculateDebts(){
        List<Debt> expectedDebt = List.of(new Debt(new Friend("Paco"), new Friend("Sonia"), BigDecimal.valueOf(10)));
        when(sharedExpensesDAO.calculateDebts(expectedGroup)).thenReturn(expectedDebt);
        List<Debt> debtList = sharedExpensesService.calculateDebts(expectedGroup);
        assertThat(debtList, is(expectedDebt));
    }

    @Test
    public void shouldAddFriendsGroup(){
        FriendsGroup expectedGroup = new FriendsGroup("Grupo2");
        when(sharedExpensesDAO.addGroup(expectedGroup)).thenReturn(expectedGroup);
        FriendsGroup group = sharedExpensesService.addGroup(expectedGroup);
        assertThat(group, is(expectedGroup));
    }

    @Test
    public void shouldAddFriend(){
        Friend expectedFriend = new Friend("Paco");
        when(sharedExpensesDAO.addFriend(expectedGroup, expectedFriend)).thenReturn(expectedFriend);
        Friend friend = sharedExpensesService.addFriend(expectedGroup, expectedFriend);
        assertThat(friend, is(expectedFriend));
    }

    @Test
    public void shouldAddPayment(){
        Payment expectedPayment = new Payment("pago1", BigDecimal.valueOf(20.0), new Friend("Paco"), date);
        when(sharedExpensesDAO.addPayment(expectedGroup, expectedPayment)).thenReturn(expectedPayment);
        Payment payment = sharedExpensesDAO.addPayment(expectedGroup, expectedPayment);
        assertThat(payment, is(expectedPayment));
    }
}
