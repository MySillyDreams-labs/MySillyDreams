package com.mysillydreams.api.service;


import com.mysillydreams.api.entity.User;

import java.util.List;

public interface UserService {

    //public void createUser(UserEntity user);
    List<User> findAll();
    User findById (int theId);
    User save (User user);

}