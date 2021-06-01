package com.sharedexpenses.usecases;

import com.sharedexpenses.domain.*;
import com.sharedexpenses.domain.converters.FriendConverter;
import com.sharedexpenses.domain.dto.FriendDTO;
import com.sharedexpenses.repository.FriendRepository;
import com.sharedexpenses.repository.FriendsGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendUseCaseImpl implements FriendUseCase {

    private final FriendRepository friendRepository;
    private final FriendsGroupRepository friendsGroupRepository;

    @Autowired
    public FriendUseCaseImpl(FriendRepository friendRepository, FriendsGroupRepository friendsGroupRepository){
        this.friendRepository = friendRepository;
        this.friendsGroupRepository = friendsGroupRepository;
    }

    // GET ALL
    @Override
    public List<Friend> getAllFriends() {
        return friendRepository.getAllFriends(); }

    //ADD
    @Override
    public Friend addFriend(FriendDTO friendDTO) {
        FriendsGroup group = friendsGroupRepository.getGroupById(friendDTO.getGroupId());
        Friend friend = FriendConverter.toFriend(friendDTO, group);
        return friendRepository.addFriend(friend);
    }

    //DELETE
    @Override
    public void deleteFriend(long id) { friendRepository.deleteFriend(id);}

}

