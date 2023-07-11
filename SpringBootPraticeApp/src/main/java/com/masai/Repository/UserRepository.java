package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{

}
