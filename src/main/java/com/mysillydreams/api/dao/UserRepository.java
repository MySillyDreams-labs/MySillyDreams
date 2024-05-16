package com.mysillydreams.api.dao;


import com.mysillydreams.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    // that's it .... No need to write any code

    User findByMobileNumber(String mobileNumber);
}
