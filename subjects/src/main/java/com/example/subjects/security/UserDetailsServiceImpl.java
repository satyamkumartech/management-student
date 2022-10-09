package com.example.subjects.security;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.subjects.entities.UserDto;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	RestTemplate restTemplate;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDto user = null;
		try {
			user = restTemplate.getForObject(new URI("http://localhost:8083/api/user/"+username), UserDto.class);
		} catch (RestClientException | URISyntaxException e) {
			e.printStackTrace();
		}
		return UserDetailsImpl.build(user);
	}

}
