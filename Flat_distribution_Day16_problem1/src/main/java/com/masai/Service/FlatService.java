package com.masai.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.Entity.Flat;
import com.masai.Exception.FlatException;

@Service
public interface FlatService {
	
	public Flat registerFlat(Flat flat) ; 
	public List<Flat> getAllFlat() throws FlatException;
	public List<Flat> findFlatByPriceLessThan(int price)throws FlatException;

	public List<Flat> findFlatByPriceLessThanEqualTo(int price)throws FlatException;

	public List<Flat> findFlatByPriceGreaterThan(int price)throws FlatException;

	public List<Flat> findFlatByPriceBetween(int s_price,int e_price)throws FlatException;
	public Flat updateFlat(Integer flatId, Flat flat) throws FlatException;
}
