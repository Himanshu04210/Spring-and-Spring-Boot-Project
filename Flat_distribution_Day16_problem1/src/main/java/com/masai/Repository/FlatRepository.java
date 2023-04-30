package com.masai.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Entity.Flat;

@Repository
public interface FlatRepository extends JpaRepository<Flat, Integer>{
	public List<Flat> findFlatByPriceLessThan(int price);

	public List<Flat> findFlatByPriceLessThanEqual(int price);

	public List<Flat> findFlatByPriceGreaterThan(int price);

	public List<Flat> findFlatByPriceBetween(int s_price,int e_price);
}
