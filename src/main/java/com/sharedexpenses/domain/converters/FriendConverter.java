package com.sharedexpenses.domain.converters;

import com.sharedexpenses.domain.Friend;
import com.sharedexpenses.domain.FriendsGroup;
import com.sharedexpenses.domain.dto.FriendDTO;

public class FriendConverter {
    public static final FriendDTO toDTO(Friend friend) {
        return new FriendDTO(friend.getId(), friend.getName(), friend.getFriendsGroup().getId());
    }
    public static final Friend toFriend(FriendDTO friendDTO, FriendsGroup group){
        return new Friend(friendDTO.getId(), friendDTO.getName(), group);
    }
}

