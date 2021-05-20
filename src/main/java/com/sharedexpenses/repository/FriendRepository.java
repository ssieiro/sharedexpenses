package com.sharedexpenses.repository;

import com.sharedexpenses.domain.Friend;

import java.util.List;

public interface FriendRepository {
    List<Friend> getAllFriends();
    Friend addFriend(Friend friend);
    void deleteFriend(long id);
}
