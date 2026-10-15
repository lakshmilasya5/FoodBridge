package com.example.foodmanagement.dto;



import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Min;

public class FoodDTO {

    @NotBlank(message = "Food name required")
    private String name;

    @Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;

    @NotBlank(message = "Location required")
    private String location;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}