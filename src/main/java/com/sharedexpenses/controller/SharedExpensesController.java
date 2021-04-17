package com.sharedexpenses.controller;

import com.sharedexpenses.domain.datamodels.*;
import com.sharedexpenses.restservice.SharedExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class SharedExpensesController {

    private final SharedExpensesService sharedExpensesService;

    @Autowired
    public SharedExpensesController(SharedExpensesService sharedExpensesService) {
        this.sharedExpensesService = sharedExpensesService;
    }

    // GET
    @GetMapping("/groups")
    public List<FriendsGroup> getAllGroups(){
        return sharedExpensesService.getAllGroups();
    }

    @GetMapping("/groups/{groupName}")
    public FriendsGroup getGroupByName(@PathVariable String groupName){

        Optional<FriendsGroup> group = sharedExpensesService.getGroupByName(groupName);

        if(group.isPresent()) {
            return group.get();
        }
        throw new RuntimeException("Group not found -"+groupName);

    }

    @GetMapping("groups/{groupName}/friends")
    public List<Friend> getFriends(@PathVariable String groupName){
        FriendsGroup group = this.getGroupByName(groupName);
        return sharedExpensesService.getFriends(group);
    }

    @GetMapping("groups/{groupName}/payments")
    public List<Payment> getPayments(@PathVariable String groupName){
        FriendsGroup group = this.getGroupByName(groupName);
        return sharedExpensesService.getPayments(group);
    }

    @GetMapping("groups/{groupName}/balance")
    public List<Balance> calculateBalance(@PathVariable String groupName){
        FriendsGroup group = this.getGroupByName(groupName);
        return sharedExpensesService.calculateBalance(group);
    }

    @GetMapping("groups/{groupName}/debts")
    public List<Debt> calculateDebts(@PathVariable String groupName){
        FriendsGroup group = this.getGroupByName(groupName);
        return sharedExpensesService.calculateDebts(group);
    }


    //POST
    @PostMapping("/groups")
    public FriendsGroup addGroup (@RequestBody FriendsGroup group) {
        return sharedExpensesService.addGroup(group);
    }

    @PostMapping("/groups/{groupName}/friends")
    public Friend addFriend (@PathVariable String groupName, @RequestBody Friend friend) {
        FriendsGroup group = this.getGroupByName(groupName);
        return sharedExpensesService.addFriend(group, friend);
    }

    @PostMapping("/groups/{groupName}/payments")
    public Payment addPayment (@PathVariable String groupName, @RequestBody Payment payment) {
        FriendsGroup group = this.getGroupByName(groupName);
        return sharedExpensesService.addPayment(group, payment);
    }

}
