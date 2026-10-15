package com.example.foodmanagement.dto;
import com.example.foodmanagement.entity.Role;

public class UserResponseDTO{
	private Long id;
	private String username;
	private Role role;
	
	public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public Long getId() {
    	return id;
    }
    public void setId(Long id) {
    	this.id=id;
    	
    }
    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

	
}