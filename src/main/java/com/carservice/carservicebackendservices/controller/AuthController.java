package com.carservice.carservicebackendservices.controller;

import com.carservice.carservicebackendservices.services.UserService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    @PermitAll
    public ResponseEntity<?> signup(@RequestBody Map<String, String> request) {
        String mobileNumber = request.get("mobileNumber");
        String email = request.get("email");
        userService.createOrUpdateUser(mobileNumber, email);
        return ResponseEntity.ok("User created/updated successfully");
    }

    @PostMapping("/send-otp")
    public ResponseEntity<?> sendOtp(@RequestBody Map<String, String> request) {
        String mobileNumber = request.get("mobileNumber");
        String otp = userService.generateOtp(mobileNumber);
        // Simulate OTP sending
        System.out.println("OTP sent to " + mobileNumber + ": " + otp);
        return ResponseEntity.ok("OTP sent successfully");
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<?> verifyOtp(@RequestBody Map<String, String> request) {
        String mobileNumber = request.get("mobileNumber");
        String otp = request.get("otp");
        boolean isValid = userService.validateOtp(mobileNumber, otp);
        if (isValid) {
            return ResponseEntity.ok("OTP verified successfully");
        } else {
            return ResponseEntity.status(400).body("Invalid or expired OTP");
        }
    }
}
