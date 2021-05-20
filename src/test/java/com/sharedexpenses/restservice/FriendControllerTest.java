package com.sharedexpenses.restservice;

import com.sharedexpenses.domain.*;
import com.sharedexpenses.usecases.FriendUseCase;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class FriendControllerTest {
    private final FriendUseCase friendUseCase = mock(FriendUseCase.class);
    private final FriendController friendController = new FriendController(friendUseCase);
    private final List<Friend> expectedFriends = List.of(new Friend("Paco", 1, 2));


    @Test
    public void shouldGetAllFriends() {
        when(friendUseCase.getAllFriends()).thenReturn(expectedFriends);
        List<Friend> friendsList = friendController.getAllFriends();
        assertThat(friendsList, is(expectedFriends));
    }

    @Test
    public void shouldAddFriend() {
        Friend expectedFriend = new Friend("Paco", 1, 1);
        when(friendUseCase.addFriend(expectedFriend)).thenReturn(expectedFriend);
        Friend friend = friendController.addFriend(expectedFriend);
        assertThat(friend, is(expectedFriend));
    }
}
