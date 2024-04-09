package com.mysillydreams.api.repository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRepository {
    @GetMapping("/users")
    public String firstEndpoint() {
        return "Hi. Welcome to MySillyDreams";
    }
}
