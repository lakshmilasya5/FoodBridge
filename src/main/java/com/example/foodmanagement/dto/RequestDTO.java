package com.example.foodmanagement.dto;



import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Min;

public class RequestDTO {

    @NotBlank
    private String ngoName;

    @NotBlank
    private String foodName;

    @Min(1)
    private int quantity;

    @NotBlank
    private String location;

    public String getNgoName() { return ngoName; }
    public void setNgoName(String ngoName) { this.ngoName = ngoName; }

    public String getFoodName() { return foodName; }
    public void setFoodName(String foodName) { this.foodName = foodName; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}