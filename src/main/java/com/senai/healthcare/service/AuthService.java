package com.senai.healthcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.senai.healthcare.model.Client;

@Service("customUserService")
public class AuthService implements UserDetailsService {

	@Autowired
	private ClientService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Client userEntity = userService.getUser(username);
        UserDetails userDetails = org.springframework.security.core.userdetails.User
        		.withUsername(userEntity.getEmail())
        		.password(userEntity.getSenha())
        		.authorities("USER").build();
		return userDetails;
	}

}
