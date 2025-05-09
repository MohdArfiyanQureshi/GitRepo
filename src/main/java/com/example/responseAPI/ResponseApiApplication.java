package com.example.responseAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EntityScan("com.example.usermanagement.entity") 
//@EnableJpaRepositories("com.example.usermanagement.repository")
//@ComponentScan({"com.example.usermanagement.entity", "com.example.usermanagement.repository",
//	            "com.example.usermanagement.controller", "com.example.usermanagement.service",
//	            "com.example.usermanagement.DTO", "com.example.usermanagement.exception",
//	            "com.example.responseAPI.comman"})

public class ResponseApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResponseApiApplication.class, args);
	}

}
