# Student Management System

A Spring Boot based REST API project for managing student records.

## Features

- Add Student
- Get All Students
- Get Student By ID
- Update Student
- Delete Student
- Search Student By Name
- Search Student By Name and Marks
- Get Students With Marks Greater Than
- Search Students Using Partial Name
- Get Top Student
- DTO Implementation
- Pagination
- Sorting
- JPQL Queries
- Native SQL Queries
- Input Validation
- Spring Security
- JWT Authentication
- Actuator Health Endpoint

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Spring Security
- JWT
- Maven
- Postman
- JUnit
- Mockito

## API Testing

All APIs were tested using Postman.

## Security

The project uses JWT authentication to protect student APIs.

Public endpoints:

- `/auth/**`
- `/actuator/health`

All other APIs require authentication.

## Database Configuration

Create a file named:

`application-dev.properties`

Use `application-dev.properties.example` as a reference and add your own database credentials.

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/studentdb
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD