package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public String Welcome() {
        String welcomeMsg = "Welcome to Springboot planet! \n chileregion";
        return welcomeMsg;
    }
}
