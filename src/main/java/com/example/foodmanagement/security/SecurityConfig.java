package com.example.foodmanagement.security;


import org.springframework.context.annotation.Bean;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration

public class SecurityConfig {
	
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth

                // PUBLIC APIs
                .requestMatchers("/api/auth/register").permitAll()
                .requestMatchers("/api/foods/foodlist").permitAll()
                // SECURE EVERYTHING ELSE
                .requestMatchers(
                 		"/api/foods/**").hasRole("DONOR")
                
                .requestMatchers(
                 		"/api/requests/**").hasRole("NGO")
                 .requestMatchers("/api/admin/**").hasRole("ADMIN")
                 		
                

                 .anyRequest().authenticated()
             )
             .formLogin(form->form.disable())
             .httpBasic(Customizer.withDefaults());
             
             
             
             
         return http.build();
     }

     // PASSWORD ENCODER 
     @Bean
     public PasswordEncoder passwordEncoder() {
         return new BCryptPasswordEncoder();
     }
 }
        
                        
                        
                        
                                
            