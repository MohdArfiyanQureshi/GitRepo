package com.example.responseAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.responseAPI.entity.User;

@Repository

public interface UserRepository extends JpaRepository<User, Long>{

	boolean existsByEmail(String email);
	
	boolean existsByPhoneNo(String phoneNo);
}
