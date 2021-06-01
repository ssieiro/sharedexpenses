package app.repository;

import domain.Friend;
import java.util.List;

public interface FriendRepository {
    List<Friend> getAllFriends();
    Friend getFriendById(long friendId);
    Friend addFriend(Friend friend);
    void deleteFriend(long id);
}
