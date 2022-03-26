package com.senai.healthcare.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.healthcare.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

	public Optional<Client> findByEmail(
			String email
			);

}
