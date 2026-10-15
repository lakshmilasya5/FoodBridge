package com.example.foodmanagement;
import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.foodmanagement.entity.Users;
import com.example.foodmanagement.entity.Role;
import com.example.foodmanagement.repository.UserRepository;

@SpringBootApplication
public class FoodmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodmanagementApplication.class, args);
	}
	@Bean
	CommandLineRunner run(UserRepository repo,PasswordEncoder encoder) {
		return args->{
			if(!repo.existsByUsername("admin")) {
				Users admin=new Users();
				admin.setUsername("admin");
				admin.setPassword(encoder.encode("admin123"));
				admin.setRole(Role.ADMIN);
				repo.save(admin);
			}
		};
	
	}

}
