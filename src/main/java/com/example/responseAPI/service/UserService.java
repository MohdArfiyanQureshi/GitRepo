package com.example.responseAPI.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.example.responseAPI.DTO.ApiResponse;
import com.example.responseAPI.DTO.UserRegisterDTO;
import com.example.responseAPI.DTO.UserResponseDTO;

import jakarta.servlet.http.HttpServletRequest;

public interface UserService {
	
	ResponseEntity<ApiResponse<UserResponseDTO>>
	addUser(UserRegisterDTO dto, HttpServletRequest request);
	
	  Page<UserResponseDTO> getUsers(Pageable pageable);

	

}
