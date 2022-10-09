package com.example.subjects.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private int userId;
	private String username;
	private String firstName;
	private String lastName;
	private String roles;
	private boolean isActive;

}
