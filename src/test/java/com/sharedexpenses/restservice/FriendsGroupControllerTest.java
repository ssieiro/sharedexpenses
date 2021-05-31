package com.sharedexpenses.restservice;

import com.sharedexpenses.domain.*;
import com.sharedexpenses.usecases.FriendsGroupUseCase;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/*
class FriendsGroupControllerTest {
    private final FriendsGroupUseCase friendsGroupUseCase = mock(FriendsGroupUseCase.class);
    private final FriendsGroupController friendsGroupController = new FriendsGroupController(friendsGroupUseCase);
    private final LocalDateTime date = LocalDateTime.now();
    private final FriendsGroup expectedGroup = new FriendsGroup("Grupo1", 1);
    private final List<Friend> expectedFriends = List.of(new Friend("Paco", 1, 2));


    @Test
    public void shouldGetGroup() {
        when(friendsGroupUseCase.getGroupById(1)).thenReturn(expectedGroup);
        FriendsGroup group = friendsGroupController.getGroupById(1);
        assertThat(group, is(expectedGroup));
    }


    @Test
    public void shouldGetFriendsByGroup() {
        when(friendsGroupUseCase.getFriendsByGroup(1)).thenReturn(expectedFriends);
        List<Friend> friendsList = friendsGroupController.getFriendsByGroup(1);
        assertThat(friendsList, is(expectedFriends));
    }

    @Test
    public void shouldGetPaymentsByGroup() {
        List<Payment> expectedPayments = List.of(new Payment("pago1", BigDecimal.valueOf(20.0), 2, date));
        when(friendsGroupUseCase.getPaymentsByGroup(1)).thenReturn(expectedPayments);
        List<Payment> paymentsList = friendsGroupController.getPaymentsByGroup(1);
        assertThat(paymentsList, is(expectedPayments));
    }

    @Test
    public void shouldCalculateBalance() {
        List<Balance> expectedBalance = List.of(new Balance(BigDecimal.valueOf(20), new Friend("Paco", 1, 2)));
        when(friendsGroupUseCase.calculateBalance(1)).thenReturn(expectedBalance);
        List<Balance> balanceList = friendsGroupController.calculateBalance(1);
        assertThat(balanceList, is(expectedBalance));
    }

    @Test
    public void shouldCalculateDebts() {
        List<Debt> expectedDebt = List.of(new Debt(new Friend("Paco", 2, 1), new Friend("Sonia", 1, 1), BigDecimal.valueOf(10)));
        when(friendsGroupUseCase.calculateDebts(1)).thenReturn(expectedDebt);
        List<Debt> debtList = friendsGroupController.calculateDebts(1);
        assertThat(debtList, is(expectedDebt));
    }

    @Test
    public void shouldAddFriendsGroup(){
        when(friendsGroupUseCase.addGroup(expectedGroup)).thenReturn(expectedGroup);
        FriendsGroup group = friendsGroupController.addGroup(expectedGroup);
        assertThat(group, is(expectedGroup));
    }
}*/