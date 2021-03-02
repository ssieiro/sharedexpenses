package com.sharedexpenses.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @GetMapping("/greeting")
    public String greeting() {
        return "Hola mundo!!";
    }
}
