package com.sharedexpenses.restservice;

import com.sharedexpenses.domain.*;
import com.sharedexpenses.usecases.FriendUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class FriendController {

    private final FriendUseCase friendUseCase;

    @Autowired
    public FriendController(FriendUseCase friendUseCase) {
        this.friendUseCase = friendUseCase;
    }

    // GET ALL
    @GetMapping("/friends")
    public List<Friend> getAllFriends(){
        return friendUseCase.getAllFriends();
    }


    //POST
    @PostMapping("/friends")
    public Friend addFriend (@RequestBody Friend friend) {
        return friendUseCase.addFriend(friend);
    }

    //DELETE
    @DeleteMapping("/friends/{id}")
    public void deleteFriend (@PathVariable long id) {
        friendUseCase.deleteFriend(id);
    }

}
