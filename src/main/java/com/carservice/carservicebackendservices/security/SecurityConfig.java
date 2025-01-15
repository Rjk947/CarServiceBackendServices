package com.carservice.carservicebackendservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Disable CSRF for H2 console
                .authorizeHttpRequests()
                .requestMatchers("/h2-console/**").authenticated() // Allow H2 console
                .anyRequest().authenticated() // Secure all other endpoints
                .and()
                .headers().frameOptions().disable(); // Allow H2 console frames
        return http.build();
    }
}
