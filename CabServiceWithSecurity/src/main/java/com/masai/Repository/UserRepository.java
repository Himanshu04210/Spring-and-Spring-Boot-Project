package com.masai.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Model.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{

	public Optional<Users> findByEmail(String email);
	
}
