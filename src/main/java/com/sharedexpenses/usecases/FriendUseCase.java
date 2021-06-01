package com.sharedexpenses.usecases;

import com.sharedexpenses.domain.*;
import com.sharedexpenses.domain.dto.FriendDTO;

import java.util.List;

public interface FriendUseCase {
    List<Friend> getAllFriends();
    Friend addFriend(FriendDTO friend);
    void deleteFriend(long id);
}

