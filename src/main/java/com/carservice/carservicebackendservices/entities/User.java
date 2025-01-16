package com.carservice.carservicebackendservices.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true, nullable = false)
    private String mobileNumber;

    @Email
    private String email;

    private LocalDateTime otpGeneratedAt;

    private String otp;

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getOtp() {
        return otp;
    }

    public @NotBlank String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(@NotBlank String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public void setOtpGeneratedAt(LocalDateTime otpGeneratedAt) {
        this.otpGeneratedAt = otpGeneratedAt;
    }

    public LocalDateTime getOtpGeneratedAt() {
        return otpGeneratedAt;
    }



}
