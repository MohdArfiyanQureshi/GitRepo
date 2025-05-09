package com.example.responseAPI.DTO;

import java.time.LocalDateTime;
import com.example.responseAPI.comman.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse <T>{

	private int code;
	private Status status;
	private String message;
	private T data;
	private String path;
	private LocalDateTime timestamp;
	
}
