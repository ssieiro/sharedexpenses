package com.sharedexpenses.usecases;

import com.sharedexpenses.domain.*;
import com.sharedexpenses.domain.defaultcalculators.DefaultBalanceCalculator;
import com.sharedexpenses.domain.defaultcalculators.DefaultDebtCalculator;
import com.sharedexpenses.repository.FriendsGroupRepository;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class FriendsGroupUseCaseTests {
    private final FriendsGroupRepository friendsGroupRepository = mock(FriendsGroupRepository.class);
    private final BalanceCalculator balanceCalculator = new DefaultBalanceCalculator();
    private final DebtCalculator debtCalculator = new DefaultDebtCalculator(balanceCalculator);
    private final FriendsGroupUseCase friendsGroupUseCase = new FriendsGroupUseCaseImpl(friendsGroupRepository, balanceCalculator, debtCalculator);
    private final LocalDateTime date = LocalDateTime.now();
    private final FriendsGroup expectedGroup = new FriendsGroup("Grupo1", 1);
    private final List<Friend> expectedFriends = List.of(new Friend("Paco",1, 2));
    private final List<Payment> expectedPayments = List.of(new Payment("pago1", BigDecimal.valueOf(20.0), 2, date));


    @Test
    void shouldGetGroupById() {
        when(friendsGroupRepository.getGroupById(1)).thenReturn(expectedGroup);
        FriendsGroup group = friendsGroupUseCase.getGroupById(1);
        assertThat(group, is(expectedGroup));
    }

    @Test
    public void shouldGetFriendsByGroup() {
        when(friendsGroupRepository.getFriendsByGroup(1)).thenReturn(expectedFriends);
        List<Friend> friendsList = friendsGroupUseCase.getFriendsByGroup(1);
        assertThat(friendsList, is(expectedFriends));
    }

    @Test
    public void shouldGetPaymentsByGroup() {
        when(friendsGroupRepository.getPaymentsByGroup(1)).thenReturn(expectedPayments);
        List<Payment> paymentsList = friendsGroupUseCase.getPaymentsByGroup(1);
        assertThat(paymentsList, is(expectedPayments));
    }


    @Test
    public void shouldAddFriendsGroup() {
        FriendsGroup expectedGroup = new FriendsGroup("Grupo2", 1);
        when(friendsGroupRepository.addGroup(expectedGroup)).thenReturn(expectedGroup);
        FriendsGroup group = friendsGroupUseCase.addGroup(expectedGroup);
        assertThat(group, is(expectedGroup));
    }

}