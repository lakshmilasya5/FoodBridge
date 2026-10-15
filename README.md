# Food Waste Management System

## Project Overview

The **Food Waste Management System** is a Spring Boot based REST API that helps reduce food waste by connecting **food donors** with **NGOs**.
Donors can donate excess food and NGOs can request the food for distribution to people in need.

---

## Features

### Donor

* Register and login
* Donate food
* View donated food
* Delete food

### NGO

* Register and login
* View available food list
* Request food from donors

### ADMIN

* Login to system
* View food donations
* Manage users

### Security

* Role-based authorization and authentication using Spring Security
* Roles: **DONOR**, **NGO** and **ADMIN**
* Secure API endpoints

---

## Technologies Used

* Java 17
* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Postman (for API testing)
* Git & GitHub

---

## Project Structure


src/main/java/com/example/foodmanagement
│
├── controller     # REST API controllers
├── dto            # Data Transfer Objects
├── entity         # Database Tables
├── repository     # Database repositories
├── service        # Business logic
├── security       # Spring Security configuration
└── exception      # Global exception handling


---

## API Endpoints

### User APIs

POST `/api/users/register`

### Food APIs (Donor)

POST `/api/foods/donate`
GET `/api/foods/foodlist`
DELETE `/api/foods/delete/{id}`

### Request APIs (NGO)

POST `/api/requests/request{foodid}`
DELETE `/api/requests/delete/{id}`

### Admin APIs (Admin)

GET `/api/admin/showusers`
GET `/api/admin/showusers/{id}`
DELETE `/api/admin/deleteusers/{id}`


---

## How to Run the Project

1. Clone the repository


git clone https://github.com/Deekshitha-Yellappagari/food-waste-management-system.git


2. Open the project in Eclipse or IntelliJ.

3. Configure MySQL in `application.properties`.

4. Run the Spring Boot application.

---

## Testing APIs

Use **Postman** to test the REST APIs.

---

## Author

Deekshitha Yellappagari
