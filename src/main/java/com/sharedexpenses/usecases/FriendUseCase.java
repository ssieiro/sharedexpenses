package com.sharedexpenses.usecases;

import com.sharedexpenses.domain.*;

import java.util.List;

public interface FriendUseCase {
    List<Friend> getAllFriends();
    Friend addFriend(Friend friend);
    void deleteFriend(long id);
}

