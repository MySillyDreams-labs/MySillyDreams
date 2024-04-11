package com.mysillydreams.api.service;


import com.mysillydreams.api.dao.UserRepository;
import com.mysillydreams.api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {

        return userRepository.findAll();
    }

    @Override
    public User findById(int theId) {
        Optional<User> result = userRepository.findById(theId);

        User theUser = null;

        if(result.isPresent()){
            theUser = result.get();
        }
        else {
            // we didn't find the user
            throw new RuntimeException("Did not find employee id - " + theId);
        }
        return theUser;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

}