package com.carservice.carservicebackendservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class CarServiceBackendServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarServiceBackendServicesApplication.class, args);
    }

}
