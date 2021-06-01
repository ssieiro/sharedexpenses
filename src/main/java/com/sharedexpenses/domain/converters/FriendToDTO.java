package com.sharedexpenses.domain.converters;

import com.sharedexpenses.domain.Friend;
import com.sharedexpenses.domain.dto.FriendDTO;

public class FriendToDTO {
    public static final FriendDTO convert (Friend friend) {
        return new FriendDTO(friend.getId(), friend.getName(), friend.getFriendsGroup().getId());
    }
}

