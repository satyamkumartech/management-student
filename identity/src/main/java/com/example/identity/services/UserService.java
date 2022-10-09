package com.example.identity.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.identity.entities.User;
import com.example.identity.entities.UserDto;
import com.example.identity.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    ModelMapper modelMapper;

    public UserDto loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User doesn't exists"));
        return modelMapper.map(user, UserDto.class);
    }
}
