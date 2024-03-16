package com.mysillydreams.eventmanagement.service;

import com.mysillydreams.eventmanagement.entity.User;

import java.util.List;

public interface UserService {

    //public void createUser(UserEntity user);
    List<User> findAll();
    User findById (int theId);
    User save (User user);
    void deleteById(int theId);
}