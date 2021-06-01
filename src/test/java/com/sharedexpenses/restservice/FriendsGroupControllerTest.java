package com.sharedexpenses.restservice;

import com.sharedexpenses.domain.*;
import com.sharedexpenses.domain.dto.BalanceDTO;
import com.sharedexpenses.domain.dto.DebtDTO;
import com.sharedexpenses.domain.dto.FriendDTO;
import com.sharedexpenses.domain.dto.PaymentDTO;
import com.sharedexpenses.usecases.FriendsGroupUseCase;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class FriendsGroupControllerTest {
    private final FriendsGroupUseCase friendsGroupUseCase = mock(FriendsGroupUseCase.class);
    private final FriendsGroupController friendsGroupController = new FriendsGroupController(friendsGroupUseCase);
    private final LocalDateTime date = LocalDateTime.now();
    private final FriendsGroup expectedGroup = new FriendsGroup(1, "Grupo1");
    private final List<FriendDTO> expectedFriendsDTO = List.of(new FriendDTO(1, "Paco", 1));
    private final List<Friend> expectedFriends = List.of(new Friend(1, "Paco", new FriendsGroup(1, "prueba test")));
    private final Friend friendPaco = new Friend(2, "Paco", new FriendsGroup(1,"Grupo test"));
    private final Friend friendSonia = new Friend(1, "Sonia", new FriendsGroup(1, "Grupo test"));
    private final FriendDTO friendPacoDTO = new FriendDTO (2, "Paco", 1);
    private final FriendDTO friendSoniaDTO = new FriendDTO(1, "Sonia", 1);

    @Test
    public void shouldGetGroup() {
        when(friendsGroupUseCase.getGroupById(1)).thenReturn(expectedGroup);
        FriendsGroup group = friendsGroupController.getGroupById(1);
        assertThat(group, is(expectedGroup));
    }


    @Test
    public void shouldGetFriendsByGroup() {
        when(friendsGroupUseCase.getFriendsByGroup(1)).thenReturn(expectedFriends);
        List<FriendDTO> friendsList = friendsGroupController.getFriendsByGroup(1);
        assertThat(friendsList, is(expectedFriendsDTO));
    }

    @Test
    public void shouldGetPaymentsByGroup() {
        List<Payment> expectedPayments = List.of(new Payment(1, "pago1", BigDecimal.valueOf(20.0), friendPaco, date));
        List<PaymentDTO> expectedPaymentsDTO = List.of(new PaymentDTO(1, "pago1", BigDecimal.valueOf(20.0), 2, date));
        when(friendsGroupUseCase.getPaymentsByGroup(1)).thenReturn(expectedPayments);
        List<PaymentDTO> paymentsList = friendsGroupController.getPaymentsByGroup(1);
        assertThat(paymentsList, is(expectedPaymentsDTO));
    }

    @Test
    public void shouldCalculateBalance() {
        List<Balance> expectedBalance = List.of(new Balance(BigDecimal.valueOf(20), friendPaco));
        List<BalanceDTO> expectedBalanceDTO = List.of(new BalanceDTO(BigDecimal.valueOf(20), friendPacoDTO));
        when(friendsGroupUseCase.calculateBalance(1)).thenReturn(expectedBalance);
        List<BalanceDTO> balanceList = friendsGroupController.calculateBalance(1);
        assertThat(balanceList, is(expectedBalanceDTO));
    }

    @Test
    public void shouldCalculateDebts() {
        List<Debt> expectedDebt = List.of(new Debt(friendPaco, friendSonia, BigDecimal.valueOf(10)));
        List<DebtDTO> expectedDebtDTO = List.of(new DebtDTO(friendPacoDTO,
                friendSoniaDTO, BigDecimal.valueOf(10)));
        when(friendsGroupUseCase.calculateDebts(1)).thenReturn(expectedDebt);
        List<DebtDTO> debtList = friendsGroupController.calculateDebts(1);
        assertThat(debtList, is(expectedDebtDTO));
    }

    @Test
    public void shouldAddFriendsGroup(){
        when(friendsGroupUseCase.addGroup(expectedGroup)).thenReturn(expectedGroup);
        FriendsGroup group = friendsGroupController.addGroup(expectedGroup);
        assertThat(group, is(expectedGroup));
    }
}