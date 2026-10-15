package com.example.foodmanagement.controller;



import com.example.foodmanagement.dto.FoodDTO;

import com.example.foodmanagement.entity.Food;
import com.example.foodmanagement.service.FoodService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @PostMapping("/donate")
    public Food addFood(@Valid @RequestBody FoodDTO dto) {
        return foodService.addFood(dto);
    }

    @GetMapping("/foodlist")
    public List<Food> getAllFoods() {
        return foodService.getAllFoods();
    }

    @GetMapping("/foodlist/{id}")
    public Food getFood(@PathVariable Long id) {
        return foodService.getFoodById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFood(@PathVariable Long id) {
        foodService.deleteFood(id);
        return "Food deleted";
    }
}