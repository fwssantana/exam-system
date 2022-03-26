package com.senai.healthcare.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.healthcare.dto.UserDTO;
import com.senai.healthcare.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "User")
@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "Create new user")
	@PostMapping
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO user) {
		userService.save(user);
		return ResponseEntity.ok(user);
	}
	
}
