package com.sharedexpenses.repository;

import com.sharedexpenses.domain.*;
import com.sharedexpenses.repository.mysqlImp.MysqlFriendsGroupRepositoryImpl;
import com.sharedexpenses.repository.mysqlImp.mappers.FriendsGroupMapper;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class FriendsGroupRepositoryTest {
    private final FriendsGroupMapper friendsGroupMapper = mock(FriendsGroupMapper.class);
    private final FriendsGroupRepository friendsGroupRepository = new MysqlFriendsGroupRepositoryImpl(friendsGroupMapper);
    private final LocalDateTime date = LocalDateTime.now();
    private final List<FriendsGroup> expectedGroups = List.of(new FriendsGroup(1,"Grupo1"));
    private final FriendsGroup expectedGroup = new FriendsGroup(1, "Grupo1");
    private final List<Friend> expectedFriends = List.of(new Friend(1, "Paco", expectedGroup));
    private final List<Payment> expectedPayments = List.of(new Payment(1, "pago1", BigDecimal.valueOf(20.0), new Friend(2, "Sonia", expectedGroup), date));

    @Test
    void shouldGetAllGroups(){
        when(friendsGroupMapper.findAllGroups()).thenReturn(expectedGroups);
        List<FriendsGroup> groups = friendsGroupRepository.getAllGroups();
        assertThat(groups, is(expectedGroups));
    }

    @Test
    void shouldGetGroupById() {
        when(friendsGroupMapper.findGroupById(1)).thenReturn(expectedGroup);
        FriendsGroup group = friendsGroupRepository.getGroupById(1);
        assertThat(group, is(expectedGroup));
    }

    @Test
    public void shouldGetFriendsByGroup() {
        when(friendsGroupMapper.findFriendsByGroup(1)).thenReturn(expectedFriends);
        List<Friend> friendsList = friendsGroupRepository.getFriendsByGroup(1);
        assertThat(friendsList, is(expectedFriends));
    }

    @Test
    public void shouldGetPaymentsByFriend() {
        when(friendsGroupMapper.findFriendsByGroup(1)).thenReturn(expectedFriends);
        when(friendsGroupMapper.findPaymentsByFriend(1)).thenReturn(expectedPayments);
        List<Payment> paymentList = friendsGroupRepository.getPaymentsByGroup(1);
        assertThat(paymentList, is(expectedPayments));
    }

}
