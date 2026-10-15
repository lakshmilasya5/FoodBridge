package com.example.foodmanagement.service;



import com.example.foodmanagement.dto.RequestDTO;

import com.example.foodmanagement.entity.FoodRequest;
import com.example.foodmanagement.repository.RequestRepository;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;
    
    @Autowired
    private FoodService foodService;
    
 // CREATE REQUEST (DTO → ENTITY)
    public FoodRequest createRequest(RequestDTO dto,Long foodid) {

        FoodRequest request = new FoodRequest();
        request.setNgoName(dto.getNgoName());
        request.setFoodName(dto.getFoodName());
        request.setQuantity(dto.getQuantity());
        request.setLocation(dto.getLocation());
        requestRepository.save(request);
        foodService.updateStatusToRequested(foodid);
        
        return request;
    }
    
 // GET ALL REQUESTS
    public List<FoodRequest> getAllRequests() {
        return requestRepository.findAll();
    }

    // GET BY ID
    public FoodRequest getRequestById(Long id) {
        return requestRepository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("Request not found with id " + id));
    }
    
    // DELETE REQUEST
    public void deleteRequest(Long id) {
        if (!requestRepository.existsById(id)) {
            throw new NoSuchElementException("Request not found with id " + id);
        }
        requestRepository.deleteById(id);
    }
}
    
    
    
    

  

    

   