package com.mysillydreams.api.repository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserRepository {


    @GetMapping
    public ResponseEntity<Map<String,String>> healthCheck(){
        return  ResponseEntity.ok().body(Map.of("Status","up"));
    }

    @GetMapping("/users")
    public String firstEndpoint() {
        return "Hi. Welcome to MySillyDreams";
    }
}
