package com.sharedexpenses.controller;

import com.sharedexpenses.domain.datamodels.FriendsGroup;
import com.sharedexpenses.restservice.SharedExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        //retornará todos los usuarios
        return sharedExpensesService.getAllGroups();
    }
}
