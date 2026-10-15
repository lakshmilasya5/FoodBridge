package com.example.foodmanagement.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.example.foodmanagement.entity.FoodRequest;

public interface RequestRepository extends JpaRepository<FoodRequest, Long> {
}
