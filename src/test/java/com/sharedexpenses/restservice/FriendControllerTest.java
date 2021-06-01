package com.sharedexpenses.restservice;

import com.sharedexpenses.domain.*;
import com.sharedexpenses.domain.dto.FriendDTO;
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

    @Test
    public void shouldGetAllFriends() {
        List<Friend> expectedFriends = List.of(new Friend(2, "Paco", new FriendsGroup(1, "Grupo test")));
        List<FriendDTO> expectedFriendsDTO = List.of(new FriendDTO(2, "Paco", 1));
        when(friendUseCase.getAllFriends()).thenReturn(expectedFriends);
        List<FriendDTO> friendsList = friendController.getAllFriends();
        assertThat(friendsList, is(expectedFriendsDTO));
    }

    @Test
    public void shouldAddFriend() {
        FriendDTO expectedfriendDTO = new FriendDTO (2, "Paco", 1);
        Friend friend = new Friend (2, "Paco", new FriendsGroup(1, "Grupo prueba"));
        when(friendUseCase.addFriend(expectedfriendDTO)).thenReturn(friend);
        FriendDTO friendDTO = friendController.addFriend(expectedfriendDTO);
        assertThat(friendDTO, is(expectedfriendDTO));
    }
}
