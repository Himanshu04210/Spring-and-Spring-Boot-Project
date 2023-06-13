package com.masai.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Entity.Truck;

public interface TruckRepository extends JpaRepository<Truck, Integer>{

	public Optional<Truck> findByTruckNumber(Integer tn);
}
