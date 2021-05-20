package com.sharedexpenses.usecases;

import com.sharedexpenses.domain.*;

import com.sharedexpenses.repository.FriendRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FriendUseCaseTests {
    private final FriendRepository friendRepository = mock(FriendRepository.class);
    private final FriendUseCase friendUseCase = new FriendUseCaseImpl(friendRepository);
    private final List<Friend> expectedFriends = List.of(new Friend("Paco",1, 2));


    @Test
    public void shouldGetAllFriends() {
        when(friendRepository.getAllFriends()).thenReturn(expectedFriends);
        List<Friend> friendsList = friendUseCase.getAllFriends();
        assertThat(friendsList, is(expectedFriends));
    }

    @Test
    public void shouldAddFriend() {
        Friend expectedFriend = new Friend("Paco",1,  1);
        when(friendRepository.addFriend(expectedFriend)).thenReturn(expectedFriend);
        Friend friend = friendUseCase.addFriend(expectedFriend);
        assertThat(friend, is(expectedFriend));
    }
}