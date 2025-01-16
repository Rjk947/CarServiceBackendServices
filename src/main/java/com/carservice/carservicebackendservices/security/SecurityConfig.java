//package com.carservice.carservicebackendservices.security;
//
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        http.csrf().disable() // Disable CSRF for simplicity (not recommended for production)
////                .authorizeHttpRequests(authorize -> authorize
////                        .requestMatchers("/api/signup").permitAll() // Allow unauthenticated access to the signup endpoint
////                        .anyRequest().authenticated() // All other requests require authentication
////                );
////
////        return http.build();
////    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChainForError(HttpSecurity http) throws Exception {
//        http.exceptionHandling().accessDeniedHandler((req, res, ex) -> {
//            res.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
//        });
//        return http.build();
//    }
//}
