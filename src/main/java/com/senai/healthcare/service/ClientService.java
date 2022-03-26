package com.senai.healthcare.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.senai.healthcare.dto.UserDTO;
import com.senai.healthcare.model.Client;
import com.senai.healthcare.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ClientRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Transactional
	public void save(UserDTO userDTO) {
		Client user = validateAndConvertUserDtoToUser(userDTO);
		user.setSenha(this.passwordEncoder.encode(userDTO.getPassword()));
		this.userRepository.save(user);
	}
	
	private Client validateAndConvertUserDtoToUser(UserDTO userDTO) {
		Client user = modelMapper.map(userDTO, Client.class);
		return user;
	}
	
	public Client getUser(String email) {
		Optional<Client> userOpt = this.userRepository.findByEmail(email);
		if(userOpt.isPresent()) {
			return userOpt.get();
		}
		
		throw new IllegalArgumentException();
	}

	public boolean login(UserDTO user) {
		Client client = this.getUser(user.getEmail());
		return passwordEncoder.matches(user.getPassword(), client.getSenha());
	}
}
