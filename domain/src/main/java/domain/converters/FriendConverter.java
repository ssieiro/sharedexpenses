package domain.converters;

import domain.Friend;
import domain.FriendsGroup;
import domain.dto.FriendDTO;

public class FriendConverter {
    public static final FriendDTO toDTO(Friend friend) {
        return new FriendDTO(friend.getId(), friend.getName(), friend.getFriendsGroup().getId());
    }
    public static final Friend toFriend(FriendDTO friendDTO, FriendsGroup group){
        return new Friend(friendDTO.getId(), friendDTO.getName(), group);
    }
}

