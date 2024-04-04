package com.mysillydreams.eventmanagement.dao;

import com.mysillydreams.eventmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    // that's it .... No need to write any code
}