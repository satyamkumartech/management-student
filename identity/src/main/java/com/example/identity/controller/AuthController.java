package com.example.identity.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.identity.dto.AuthRequest;
import com.example.identity.dto.JwtResponse;
import com.example.identity.entities.User;
import com.example.identity.models.UserRole;
import com.example.identity.repository.UserRepository;
import com.example.identity.security.JwtUtils;
import com.example.identity.security.UserDetailsImpl;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@RequestBody AuthRequest authRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwtToken = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.collect(Collectors.toList());

		return ResponseEntity
				.ok(new JwtResponse(jwtToken, "Bearer", userDetails.getId(), userDetails.getUsername(), roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<String> registerUser(@RequestBody User user) {
//		user.setRoles(UserRole.ROLE_STUDENT.name());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		if (!userRepository.existsByUsername(user.getUsername())) {
			this.userRepository.save(user);
			return ResponseEntity.ok("User Registered successfully");
		}
		return ResponseEntity.badRequest().body("username is already exist!");
	}

}
