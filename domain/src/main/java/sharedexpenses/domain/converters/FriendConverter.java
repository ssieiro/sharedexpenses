package sharedexpenses.domain.converters;

import sharedexpenses.domain.Friend;
import sharedexpenses.domain.FriendsGroup;
import sharedexpenses.domain.dto.FriendDTO;

public class FriendConverter {
    public static final FriendDTO toDTO(Friend friend) {
        return new FriendDTO(friend.getId(), friend.getName(), friend.getFriendsGroup().getId());
    }
    public static final Friend toFriend(FriendDTO friendDTO, FriendsGroup group){
        return new Friend(friendDTO.getId(), friendDTO.getName(), group);
    }
}

