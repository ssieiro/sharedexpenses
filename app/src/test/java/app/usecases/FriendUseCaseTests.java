package app.usecases;

import domain.Friend;
import domain.FriendsGroup;
import domain.dto.FriendDTO;
import app.repository.FriendRepository;
import app.repository.FriendsGroupRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class FriendUseCaseTests {
    private final FriendRepository friendRepository = mock(FriendRepository.class);
    private final FriendsGroupRepository friendsGroupRepository = mock(FriendsGroupRepository.class);
    private final FriendUseCase friendUseCase = new FriendUseCaseImpl(friendRepository, friendsGroupRepository);

    @Test
    public void shouldGetAllFriends() {
        List<Friend> expectedFriends = List.of(new Friend(1,"Paco", new FriendsGroup(2, "Prueba test")));
        when(friendRepository.getAllFriends()).thenReturn(expectedFriends);
        List<Friend> friendsList = friendUseCase.getAllFriends();
        assertThat(friendsList, is(expectedFriends));
    }

    @Test
    public void shouldAddFriend() {
        FriendDTO friendDTO = new FriendDTO(1, "Paco",  2);
        Friend expectedFriend = new Friend(1, "Paco",  new FriendsGroup(2,"Prueba test"));
        when(friendRepository.addFriend(expectedFriend)).thenReturn(expectedFriend);
        Friend friend = friendUseCase.addFriend(friendDTO);
        assertThat(friend, Matchers.is(expectedFriend));
    }
}