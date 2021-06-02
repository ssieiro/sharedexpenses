package sharedexpenses.app.repository;

import sharedexpenses.domain.Friend;
import java.util.List;

public interface FriendRepository {
    List<Friend> getAllFriends();
    Friend getFriendById(long friendId);
    Friend addFriend(Friend friend);
    void deleteFriend(long id);
}
