package com.example.identity;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IdentityApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdentityApplication.class, args);
	}
	
	@Bean 
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
