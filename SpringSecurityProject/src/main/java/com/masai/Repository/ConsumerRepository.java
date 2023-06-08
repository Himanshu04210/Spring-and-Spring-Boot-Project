package com.masai.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Model.Consumer;

public interface ConsumerRepository extends JpaRepository<Consumer, Integer>{
	public Optional<Consumer> findByEmail(String email);
}
