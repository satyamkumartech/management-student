package com.example.identity.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JwtResponse {
	
	private String jwtToken;
	private String tokenType;
	private int id;
	private String username;
	private List<String> roles;
	
	
}
