package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Entity.Flat;
import com.masai.Service.FlatService;

import jakarta.validation.Valid;

@RestController
public class FlatController {

	@Autowired
	private FlatService flatService;
	
	
	@PostMapping("/flats")
	public ResponseEntity<Flat> registerFlat(@Valid @RequestBody Flat flat) {
		Flat f = flatService.registerFlat(flat);
		return new ResponseEntity<Flat>(f, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/flats")
	public ResponseEntity<List<Flat>> getAllFlat() {
		
		List<Flat> flats = flatService.getAllFlat();
		return new ResponseEntity<>(flats, HttpStatus.OK);
	}
	
	@GetMapping("/flatsLessThenPrice/{price}")
	public ResponseEntity<List<Flat>> findFlatByPriceLessThan(@PathVariable("price") Integer price) {
		
		List<Flat> flats = flatService.findFlatByPriceLessThan(price);
		return new ResponseEntity<>(flats, HttpStatus.FOUND);
	}
	
	@GetMapping("/flatsLessThenEqualPrice/{price}")
	public ResponseEntity<List<Flat>> findFlatByPriceLessThanEqual(@PathVariable("price") Integer price) {
		
		List<Flat> flats = flatService.findFlatByPriceLessThanEqualTo(price);
		return new ResponseEntity<>(flats, HttpStatus.FOUND);
	}
	
}














