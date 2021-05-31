package com.sharedexpenses.usecases;

import com.sharedexpenses.domain.*;
import com.sharedexpenses.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FriendUseCaseImpl implements FriendUseCase {

    private final FriendRepository friendRepository;

    @Autowired
    public FriendUseCaseImpl(FriendRepository friendRepository){
        this.friendRepository = friendRepository;
    }

    // GET ALL
    @Override
    public List<Friend> getAllFriends() {
        return friendRepository.getAllFriends(); }

    //ADD
    @Override
    public Friend addFriend(FriendDTO friend) { return friendRepository.addFriend(friend); }

    //DELETE
    @Override
    public void deleteFriend(long id) { friendRepository.deleteFriend(id);}

}

