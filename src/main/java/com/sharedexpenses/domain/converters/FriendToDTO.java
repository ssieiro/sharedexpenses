package com.sharedexpenses.domain.converters;

import com.sharedexpenses.domain.Friend;
import com.sharedexpenses.domain.FriendDTO;

public class FriendToDTO {
    public static final FriendDTO convert (Friend friend) {
        return new FriendDTO(friend.getName(), friend.getFriendsGroup().getId(), friend.getId());
    }
}

