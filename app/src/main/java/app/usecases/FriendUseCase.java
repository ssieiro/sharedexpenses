package app.usecases;

import domain.Friend;
import domain.dto.FriendDTO;

import java.util.List;

public interface FriendUseCase {
    List<Friend> getAllFriends();
    Friend addFriend(FriendDTO friend);
    void deleteFriend(long id);
}

