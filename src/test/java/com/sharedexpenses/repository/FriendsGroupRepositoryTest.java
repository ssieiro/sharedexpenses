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

/*
public class FriendsGroupRepositoryTest {
    private final FriendsGroupMapper friendsGroupMapper = mock(FriendsGroupMapper.class);
    private final FriendsGroupRepository friendsGroupRepository = new MysqlFriendsGroupRepositoryImpl(friendsGroupMapper);
    private final LocalDateTime date = LocalDateTime.now();
    private final List<FriendsGroup> expectedGroups = List.of(new FriendsGroup("Grupo1", 1));
    private final FriendsGroup expectedGroup = new FriendsGroup("Grupo1", 1);
    private final List<Friend> expectedFriends = List.of(new Friend("Paco",1, 2));
    private final List<Payment> expectedPayments = List.of(new Payment("pago1", BigDecimal.valueOf(20.0), 2, date));

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

}*/
