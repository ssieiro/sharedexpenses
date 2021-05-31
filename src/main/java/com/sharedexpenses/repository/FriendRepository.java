package com.sharedexpenses.repository;

import com.sharedexpenses.domain.Friend;
import com.sharedexpenses.domain.FriendDTO;

import java.util.List;

public interface FriendRepository {
    List<Friend> getAllFriends();
    Friend getFriendById(long friendId);
    Friend addFriend(FriendDTO friend);
    void deleteFriend(long id);
}
