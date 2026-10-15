package com.example.foodmanagement.entity;



import jakarta.persistence.*;


@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodid;

    private String name;
    private int quantity;
    private String location;
    
    

    @Enumerated(EnumType.STRING)
    private FoodStatus status;

    public Long getfoodId() { return foodid; }
    public void setfoodId(Long foodid) { this.foodid = foodid; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    
    

    public FoodStatus getStatus() { return status; }
    public void setStatus(FoodStatus status) { this.status = status; }
}