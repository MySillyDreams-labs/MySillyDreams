package com.mysillydreams.eventmanagement.service;

import com.mysillydreams.eventmanagement.dao.UserRepository;
import com.mysillydreams.eventmanagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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

    @Override
    public void deleteById(int theId) {

        userRepository.deleteById(theId);
    }

//    @Override
//    public User findByMobileNumber(String mobileNumber) {
//        return userRepository.findByMobileNumber(mobileNumber);
//    }

    @Override
    public String generateAndSendOTP(String mobileNumber) {
        // Generate random 6-digit OTP
//        Random random = new Random();
//        String otp = String.format("%06d", random.nextInt(1000000));
//
//        // Find user by mobile number
//        User user = userRepository.findByMobileNumber(mobileNumber);
//        if (user != null) {
//            // Set OTP and expiry time
//            user.setMobileOTP(otp);
//            user.setOtpExpiryTime(LocalDateTime.now().plusMinutes(5)); // OTP expires after 5 minutes
//            userRepository.save(user);
//
//            // Send OTP to user's mobile number (you can implement your SMS sending logic here)
//
//            System.out.println("OTP sent to " + mobileNumber + ": " + otp);
//
//            return otp;
//        } else {
//            throw new RuntimeException("User not found for mobile number: " + mobileNumber);
//        }
        return null;
    }


}