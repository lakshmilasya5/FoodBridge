
package com.example.foodmanagement.service;

import com.example.foodmanagement.dto.UserDTO;
import com.example.foodmanagement.dto.UserResponseDTO;
import com.example.foodmanagement.entity.Role;
import com.example.foodmanagement.entity.Users;
import com.example.foodmanagement.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // REGISTER USER
    public Users registerUser(UserDTO dto) {

        // CHECK DUPLICATE USERNAME
        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new IllegalArgumentException(
                    "Username already exists: " + dto.getUsername()
            );
        }

        Users user = new Users();
        user.setUsername(dto.getUsername());

        // ENCRYPT PASSWORD
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        // CONVERT STRING ROLE TO ENUM
        user.setRole(Role.valueOf(dto.getRole().toUpperCase()));

        return userRepository.save(user);
    }

    // GET ALL USERS
    public List<UserResponseDTO> getAllUsers() {

        List<Users> users = userRepository.findAll();
        List<UserResponseDTO> response = new ArrayList<>();

        for (Users user : users) {
            UserResponseDTO dto = new UserResponseDTO();

            dto.setId(user.getId());
            dto.setUsername(user.getUsername());
            dto.setRole(user.getRole());

            response.add(dto);
        }

        return response;
    }

    // GET USER BY ID
    public Users getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException(
                                "User not found with id " + id
                        )
                );
    }

    // DELETE USER
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
