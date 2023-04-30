package com.masai.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entity.Flat;
import com.masai.Exception.FlatException;
import com.masai.Repository.FlatRepository;

@Service
public class FlatServiceImple implements FlatService {
	
	@Autowired
	private FlatRepository flatRepository;

	@Override
	public Flat registerFlat(Flat flat) {
		
		Flat f = flatRepository.save(flat);
		return f;
	}

	@Override
	public List<Flat> getAllFlat() throws FlatException {
		
		List<Flat> flats = flatRepository.findAll();
		if(flats.isEmpty()) throw new FlatException("No flat is present here");
		
		return flats;
	}

	@Override
	public List<Flat> findFlatByPriceLessThan(int price) throws FlatException {
		List<Flat> flats = flatRepository.findFlatByPriceLessThan(price);
		if(flats.isEmpty()) throw new FlatException("No flat is present here");
		
		return flats;
	}

	@Override
	public List<Flat> findFlatByPriceLessThanEqualTo(int price) throws FlatException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Flat> findFlatByPriceGreaterThan(int price) throws FlatException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Flat> findFlatByPriceBetween(int s_price, int e_price) throws FlatException {
		// TODO Auto-generated method stub
		return null;
	}

}
