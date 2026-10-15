package com.example.foodmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodmanagement.dto.UserDTO;
import com.example.foodmanagement.service.UserService;







import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
    private UserService userService;
	
	@PostMapping("/register")
    public String registerUser(@Valid @RequestBody UserDTO dto) {
        userService.registerUser(dto);
        return "User  created successfully";
    }

}
