package com.example.responseAPI.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.responseAPI.DTO.ApiResponse;
import com.example.responseAPI.DTO.UserRegisterDTO;
import com.example.responseAPI.DTO.UserResponseDTO;
import com.example.responseAPI.comman.Status;
import com.example.responseAPI.entity.User;
import com.example.responseAPI.repository.UserRepository;


import jakarta.servlet.http.HttpServletRequest;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
    public ResponseEntity<ApiResponse<UserResponseDTO>> addUser(UserRegisterDTO dto, 
    		HttpServletRequest request) {

        // Check if the email already exists
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("Email already registered");  // Throw error if email is already registered
        }

        // Check if the phone number already exists
        if (userRepository.existsByPhoneNo(dto.getPhoneNo())) {
            throw new IllegalArgumentException("Phone number already registered");  // Throw error if phone number is already registered
        }

        // If validations pass, create a new User entity
        User user = new User();
        user.setName(dto.getName());
        user.setAge(dto.getAge());
        user.setEmail(dto.getEmail());
        user.setPhoneNo(dto.getPhoneNo());
        user.setPassword(dto.getPassword());

        // Save the new user to the database
        userRepository.save(user);

        // Prepare the response DTO to return (excluding sensitive information like password)
        UserResponseDTO responseDto = new UserResponseDTO(
                user.getName(),
                user.getEmail(),
                user.getPhoneNo()
        );

        // Build the ApiResponse to return
        ApiResponse<UserResponseDTO> response = new ApiResponse<>(
                HttpStatus.CREATED.value(),  // Status 201 (Created)
                Status.SUCCESS,              // Success status
                "User registered successfully", // Message indicating success
                responseDto,                 // Data to return (user details)
                request.getRequestURI(),     // Path of the request
                LocalDateTime.now()          // Timestamp for when the request was made
        );

        // Return the response with HTTP status 201 (Created)
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
	

       @Override
        public Page<UserResponseDTO> getUsers(Pageable pageable){
	
	// -> Step 1: Fetch paginated list of User entities from the database
	Page<User> userPage = userRepository.findAll(pageable);
	
	// -> Step 2: Convert each User entity to a UserResponseDTO using map()
	Page<UserResponseDTO> dto = userPage.map(user -> new UserResponseDTO(
			user.getName(),
			user.getEmail(),
			user.getPhoneNo()
			));
	
	return dto;
}
       

}




