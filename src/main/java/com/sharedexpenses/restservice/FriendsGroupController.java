package com.sharedexpenses.restservice;

import com.sharedexpenses.domain.*;
import com.sharedexpenses.usecases.FriendsGroupUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class FriendsGroupController {

    private final FriendsGroupUseCase friendsGroupUseCase;

    @Autowired
    public FriendsGroupController(FriendsGroupUseCase friendsGroupUseCase) {
        this.friendsGroupUseCase = friendsGroupUseCase;
    }

    // GET ALL
    @GetMapping("/groups")
    public List<FriendsGroup> getAllGroups(){
        return friendsGroupUseCase.getAllGroups();
    }

    //GET BY GROUPID
    @GetMapping("/groups/{id}")
    public FriendsGroup getGroupById(@PathVariable long id){return friendsGroupUseCase.getGroupById(id);}

    @GetMapping("groups/{groupId}/friends")
    public List<Friend> getFriendsByGroup(@PathVariable long groupId){return friendsGroupUseCase.getFriendsByGroup(groupId);}

    @GetMapping("groups/{groupId}/payments")
    public List<Payment> getPaymentsByGroup(@PathVariable long groupId){return friendsGroupUseCase.getPaymentsByGroup(groupId); }

    //GET BALANCE AND DEBT
    @GetMapping("groups/{groupId}/balance")
    public List<Balance> calculateBalance(@PathVariable long groupId){return friendsGroupUseCase.calculateBalance(groupId);}

    @GetMapping("groups/{groupId}/debts")
    public List<Debt> calculateDebts(@PathVariable long groupId){return friendsGroupUseCase.calculateDebts(groupId);}

    //POST
    @PostMapping("/groups")
    public FriendsGroup addGroup (@RequestBody FriendsGroup group) {
        return friendsGroupUseCase.addGroup(group);
    }

    //DELETE
    @DeleteMapping("/groups/{id}")
    public void deleteGroup (@PathVariable long id) { friendsGroupUseCase.deleteGroup(id); }

}
