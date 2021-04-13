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

    @Autowired
    private SharedExpensesService sharedExpensesService;


    // GET
    @GetMapping("/greetings")
    public String greeting() {
        return "Hola mundo!!";
    }

    @GetMapping("/groups")
    public List<FriendsGroup> getAllGroups(){
        return sharedExpensesService.getAllGroups();
    }

    @GetMapping("/groups/{groupName}")
    public FriendsGroup getGroup(@PathVariable String groupName){

        Optional<FriendsGroup> group = sharedExpensesService.findGroupByName(groupName);

        if(group.isPresent()) {
            return group.get();
        }
        throw new RuntimeException("Group not found -"+groupName);

    }

    @GetMapping("groups/{groupName}/friends")
    public List<Friend> getFriends(@PathVariable String groupName){
        FriendsGroup group = this.getGroup(groupName);
        return sharedExpensesService.getFriends(group);
    }

    @GetMapping("groups/{groupName}/payments")
    public List<Payment> getPayments(@PathVariable String groupName){
        FriendsGroup group = this.getGroup(groupName);
        return sharedExpensesService.getPayments(group);
    }

    @GetMapping("groups/{groupName}/balance")
    public List<Balance> calculateBalance(@PathVariable String groupName){
        FriendsGroup group = this.getGroup(groupName);
        return sharedExpensesService.calculateBalance(group);
    }

    @GetMapping("groups/{groupName}/debts")
    public List<Debt> calculateDebts(@PathVariable String groupName){
        FriendsGroup group = this.getGroup(groupName);
        return sharedExpensesService.calculateDebts(group);
    }


    //POST
    @PostMapping("/groups")
    public FriendsGroup addGroup (@RequestBody FriendsGroup group) {
        return sharedExpensesService.addGroup(group);
    }

    @PostMapping("/groups/{groupName}/friends")
    public Friend addFriend (@PathVariable String groupName, @RequestBody Friend friend) {
        FriendsGroup group = this.getGroup(groupName);
        return sharedExpensesService.addFriend(group, friend);
    }

    @PostMapping("/groups/{groupName}/payments")
    public Payment addPayment (@PathVariable String groupName, @RequestBody Payment payment) {
        FriendsGroup group = this.getGroup(groupName);
        return sharedExpensesService.addPayment(group, payment);
    }

}
