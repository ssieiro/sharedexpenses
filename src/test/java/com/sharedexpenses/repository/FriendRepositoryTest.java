package com.sharedexpenses.repository;

import com.sharedexpenses.domain.Friend;
import com.sharedexpenses.domain.FriendsGroup;
import com.sharedexpenses.repository.mysqlImp.MysqlFriendRepositoryImpl;
import com.sharedexpenses.repository.mysqlImp.mappers.FriendMapper;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FriendRepositoryTest {
    private final FriendMapper friendMapper = mock(FriendMapper.class);
    private final FriendRepository friendRepository = new MysqlFriendRepositoryImpl(friendMapper);


    @Test
    public void shouldGetAllFriends() {
        List<Friend> expectedFriends = List.of(new Friend(1, "Paco",new FriendsGroup("Grupo test")));
        when(friendMapper.findAllFriends()).thenReturn(expectedFriends);
        List<Friend> friendsList = friendRepository.getAllFriends();
        assertThat(friendsList, is(expectedFriends));
    }

}
