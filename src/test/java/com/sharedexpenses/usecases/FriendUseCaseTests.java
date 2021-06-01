package com.sharedexpenses.usecases;

import com.sharedexpenses.domain.*;

import com.sharedexpenses.domain.dto.FriendDTO;
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

    @Test
    public void shouldGetAllFriends() {
        List<Friend> expectedFriends = List.of(new Friend(1,"Paco", new FriendsGroup("Prueba test", 2)));
        when(friendRepository.getAllFriends()).thenReturn(expectedFriends);
        List<Friend> friendsList = friendUseCase.getAllFriends();
        assertThat(friendsList, is(expectedFriends));
    }

    @Test
    public void shouldAddFriend() {
        FriendDTO friendDTO = new FriendDTO(1, "Paco",  2);
        Friend expectedFriend = new Friend(1, "Paco",  new FriendsGroup("Prueba test", 2));
        when(friendRepository.addFriend(friendDTO)).thenReturn(expectedFriend);
        Friend friend = friendUseCase.addFriend(friendDTO);
        assertThat(friend, is(expectedFriend));
    }
}