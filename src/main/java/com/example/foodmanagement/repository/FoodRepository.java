package com.example.foodmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.foodmanagement.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {
	
}