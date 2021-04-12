package com.sharedexpenses.controller;

import com.sharedexpenses.domain.datamodels.Balance;
import com.sharedexpenses.domain.datamodels.Debt;
import com.sharedexpenses.domain.datamodels.FriendsGroup;
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

    @GetMapping("groups/{groupName}/balance")
    public List<Balance> calculateBalance(@PathVariable String groupName){
        return sharedExpensesService.calculateBalance(groupName);
    }

    @GetMapping("groups/{groupName}/debts")
    public List<Debt> calculateDebts(@PathVariable String groupName){
        return sharedExpensesService.calculateDebts(groupName);
    }

}
