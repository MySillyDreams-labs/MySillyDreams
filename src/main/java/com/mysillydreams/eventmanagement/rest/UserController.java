package com.mysillydreams.eventmanagement.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/hello")
    public void hello(){
        System.out.println("Hi EC2");
    }

}