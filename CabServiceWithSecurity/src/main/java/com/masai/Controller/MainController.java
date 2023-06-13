package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.TruckException;
import com.masai.Exception.UserException;
import com.masai.Model.Truck;
import com.masai.Model.Users;
import com.masai.Service.MainSerive;

@RestController
public class MainController {

	@Autowired
	private MainSerive mainSerive;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/user")
	public ResponseEntity<Users> registerUser(@RequestBody Users user) throws UserException {
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		Users savedUser = mainSerive.registerUser(user);
		
		return new ResponseEntity<Users>(savedUser, HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/trucks/email")
	public ResponseEntity<Truck> getTruckByEmail(@PathVariable String email) throws UserException, TruckException {
		Truck truck = mainSerive.getTruckByEmail(email);
		
		return new ResponseEntity<Truck>(truck, HttpStatus.ACCEPTED);
	}

	
	@GetMapping("/trucks")
	public ResponseEntity<List<Truck>> getAllTruck() throws UserException, TruckException {
		List<Truck> trucks = mainSerive.getAllTruck();
		
		return new ResponseEntity<>(trucks, HttpStatus.ACCEPTED);
	}
	
	
	
}
