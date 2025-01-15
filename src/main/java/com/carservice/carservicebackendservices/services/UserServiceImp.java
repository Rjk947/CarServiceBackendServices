package com.carservice.carservicebackendservices.services;

import com.carservice.carservicebackendservices.entities.User;
import com.carservice.carservicebackendservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createOrUpdateUser(String mobileNumber, String email) {
        User user = userRepository.findByMobileNumber(mobileNumber)
                .orElse(new User());
        user.setMobileNumber(mobileNumber);
        if (email != null) user.setEmail(email);
        return userRepository.save(user);
    }

    @Override
    public String generateOtp(String mobileNumber) {
        User user = userRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new RuntimeException("User not found"));
        String otp = String.valueOf(new Random().nextInt(899999) + 100000);
        user.setOtp(otp);
        user.setOtpGeneratedAt(LocalDateTime.now());
        userRepository.save(user);
        return otp;
    }

    @Override
    public boolean validateOtp(String mobileNumber, String otp) {
        User user = userRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return otp.equals(user.getOtp()) && user.getOtpGeneratedAt().isAfter(LocalDateTime.now().minusMinutes(5));
    }
}
