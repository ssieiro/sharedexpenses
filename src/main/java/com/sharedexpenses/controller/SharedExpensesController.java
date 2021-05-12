package com.sharedexpenses.controller;

import com.sharedexpenses.domain.datamodels.*;
import com.sharedexpenses.restservice.SharedExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class SharedExpensesController {

    private final SharedExpensesService sharedExpensesService;

    @Autowired
    public SharedExpensesController(SharedExpensesService sharedExpensesService) {
        this.sharedExpensesService = sharedExpensesService;
    }

    // GET ALL
    @GetMapping("/groups")
    public List<FriendsGroup> getAllGroups(){
        return sharedExpensesService.getAllGroups();
    }

    @GetMapping("/friends")
    public List<Friend> getAllFriends(){
        return sharedExpensesService.getAllFriends();
    }

    @GetMapping("/payments")
    public List<Payment> getAllPayments(){
        return sharedExpensesService.getAllPayments();
    }

    //GET BY ID
    @GetMapping("/groups/{id}")
    public FriendsGroup getGroupById(@PathVariable long id){return sharedExpensesService.getGroupById(id);}

    @GetMapping("groups/{groupId}/friends")
    public List<Friend> getFriendsByGroup(@PathVariable long groupId){return sharedExpensesService.getFriendsByGroup(groupId);}

    @GetMapping("groups/{groupId}/payments")
    public List<Payment> getPaymentsByGroup(@PathVariable long groupId){return sharedExpensesService.getPaymentsByGroup(groupId); }

    //GET BALANCE AND DEBT
    @GetMapping("groups/{groupId}/balance")
    public List<Balance> calculateBalance(@PathVariable long groupId){return sharedExpensesService.calculateBalance(groupId);}

    @GetMapping("groups/{groupId}/debts")
    public List<Debt> calculateDebts(@PathVariable long groupId){return sharedExpensesService.calculateDebts(groupId);}


    //POST
    @PostMapping("/groups")
    public FriendsGroup addGroup (@RequestBody FriendsGroup group) {
        return sharedExpensesService.addGroup(group);
    }


    @PostMapping("/friends")
    public Friend addFriend (@RequestBody Friend friend) {
        return sharedExpensesService.addFriend(friend);
    }

    @PostMapping("/payments")
    public Payment addPayment (@RequestBody Payment payment) {
        return sharedExpensesService.addPayment(payment);
    }
}
