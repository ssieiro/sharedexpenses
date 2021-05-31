package com.sharedexpenses.usecases;

import com.sharedexpenses.domain.*;

import java.util.List;

public interface FriendUseCase {
    List<Friend> getAllFriends();
    Friend addFriend(FriendDTO friend);
    void deleteFriend(long id);
}

