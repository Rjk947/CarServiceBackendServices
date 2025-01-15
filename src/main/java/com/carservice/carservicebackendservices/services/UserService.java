package com.carservice.carservicebackendservices.services;

import com.carservice.carservicebackendservices.entities.User;

public interface UserService {
    public User createOrUpdateUser(String mobileNumber, String email);
    public String generateOtp(String mobileNumber);
    public boolean validateOtp(String mobileNumber, String otp);
}
