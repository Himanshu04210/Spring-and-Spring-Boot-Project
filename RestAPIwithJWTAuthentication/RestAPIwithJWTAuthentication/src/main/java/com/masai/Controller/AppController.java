package com.masai.Controller;

import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Entity.Truck;
import com.masai.Entity.Users;
import com.masai.Exception.TruckException;
import com.masai.Exception.UserException;
import com.masai.Repository.UserRepository;
import com.masai.Service.UserDao;

@RestController
public class AppController {

	@Autowired
	private UserDao userDao;
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/signIn")
	public ResponseEntity<Users> getLoggedInUser(Authentication at){
		Users users = userRepository.findByEmail(at.getClass().getName()).orElseThrow(() -> new BadCredentialsException("Invalid Username or password"));
		return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/users")
	public ResponseEntity<Users> addNewUser(@RequestBody Users users) throws UserException{
		Users user2 = userDao.createNewUser(users);
		
		return new ResponseEntity<Users>(user2,HttpStatus.CREATED);
	}
	
	@GetMapping("/truck/{userId}")
	public ResponseEntity<Truck> getTruckByUserId(@PathVariable Integer id) throws TruckException{
		Truck truck = userDao.findTruckByUserId(id);
		
		return new ResponseEntity<Truck>(truck,HttpStatus.FOUND);
	}
	
	@GetMapping("/trucks")
	public ResponseEntity<List<Truck>> getAllTrucks() throws TruckException{
		List<Truck> trucks = userDao.getAllTruck();
		return new ResponseEntity<List<Truck>>(trucks,HttpStatus.FOUND);
	}
	
	
}
