package com.mysillydreams.eventmanagement.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/hello")
    public String hello() {
        return "<h1>Welcome to MySillyDreams</h1>" +
                "<h2>A place where dreams come true!</h2>" +
                "<a href='https://www.mysillydreams.com'>Visit MySillyDreams</a>";
    }


}