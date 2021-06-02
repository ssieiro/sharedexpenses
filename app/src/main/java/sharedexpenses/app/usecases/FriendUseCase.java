package sharedexpenses.app.usecases;

import sharedexpenses.domain.Friend;
import sharedexpenses.domain.dto.FriendDTO;

import java.util.List;

public interface FriendUseCase {
    List<Friend> getAllFriends();
    Friend addFriend(FriendDTO friend);
    void deleteFriend(long id);
}

