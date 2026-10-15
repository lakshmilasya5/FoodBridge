package com.example.foodmanagement.controller;



import com.example.foodmanagement.dto.RequestDTO;


import com.example.foodmanagement.entity.FoodRequest;
import com.example.foodmanagement.service.RequestService;


import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class RequestController {

    @Autowired
    private RequestService requestService;

    // CREATE REQUEST (DTO + VALIDATION)
    @PostMapping("/request")
    public FoodRequest createRequest(@Valid @RequestBody RequestDTO dto,@RequestParam Long foodid) {
        return requestService.createRequest(dto,foodid);
    }

    // GET ALL REQUESTS
    @GetMapping("/requestlist")
    public List<FoodRequest> getAllRequests() {
        return requestService.getAllRequests();
    }

    // GET REQUEST BY ID
    @GetMapping("/requestlist/{id}")
    public FoodRequest getRequestById(@PathVariable Long id) {
        return requestService.getRequestById(id);
    }

    // DELETE REQUEST
    @DeleteMapping("/delete/{id}")
    public String deleteRequest(@PathVariable Long id) {
        requestService.deleteRequest(id);
        return "Request deleted successfully";
    }
}