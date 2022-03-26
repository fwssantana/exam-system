package com.senai.healthcare.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.healthcare.dto.UserDTO;
import com.senai.healthcare.model.User;
import com.senai.healthcare.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void save(UserDTO userDTO) {
		User user = validateAndConvertUserDtoToUser(userDTO);
		this.userRepository.save(user);
	}
	
	private User validateAndConvertUserDtoToUser(UserDTO userDTO) {
		User user = modelMapper.map(userDTO, User.class);
		return user;
	}
}
