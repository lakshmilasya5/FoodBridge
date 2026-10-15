package com.example.foodmanagement.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.foodmanagement.entity.Users;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    boolean existsByUsername(String username);
    Optional<Users> findByUsername(String username);
}