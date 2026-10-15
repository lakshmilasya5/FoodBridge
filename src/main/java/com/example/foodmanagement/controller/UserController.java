
package com.example.foodmanagement.controller;

import com.example.foodmanagement.dto.UserResponseDTO;
import com.example.foodmanagement.entity.Users;
import com.example.foodmanagement.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class UserController {

    @Autowired
    private UserService userService;

    // GET ALL USERS
    @GetMapping("/showusers")
    public List<UserResponseDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    // GET USER BY ID
    @GetMapping("/showusers/{id}")
    public UserResponseDTO getUserById(@PathVariable Long id) {
        Users user = userService.getUserById(id);

        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setRole(user.getRole());

        return dto;
    }

    // DELETE USER
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User deleted";
    }
}
