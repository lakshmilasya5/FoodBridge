package com.example.foodmanagement.service;



import com.example.foodmanagement.dto.FoodDTO;

import com.example.foodmanagement.entity.Food;
import com.example.foodmanagement.entity.FoodStatus;
import com.example.foodmanagement.repository.FoodRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    // DTO → ENTITY
    public Food addFood(FoodDTO dto) {

        Food food = new Food();
        food.setName(dto.getName());
        food.setQuantity(dto.getQuantity());
        food.setLocation(dto.getLocation());
        food.setStatus(FoodStatus.AVAILABLE);

        return foodRepository.save(food);
    }
   
    public void updateStatusToRequested(Long foodid)
    {
    	Food food=foodRepository.findById(foodid).orElseThrow(()->new RuntimeException("Food not found"));
    	if(food.getStatus()!=FoodStatus.AVAILABLE) {
    		throw new RuntimeException("food not available");
    	}
    	food.setStatus(FoodStatus.REQUESTED);
    	foodRepository.save(food);
    	
    	}
    

    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    public Food getFoodById(Long foodid) {
        return foodRepository.findById(foodid).orElse(null);
    }

    public void deleteFood(Long foodid) {
        foodRepository.deleteById(foodid);
    }
}