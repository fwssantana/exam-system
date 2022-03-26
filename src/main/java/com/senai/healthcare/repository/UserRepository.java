package com.senai.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.healthcare.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	
}
