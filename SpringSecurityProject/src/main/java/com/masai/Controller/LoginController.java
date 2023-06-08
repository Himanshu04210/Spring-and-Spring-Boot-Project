package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Model.Consumer;
import com.masai.Repository.ConsumerRepository;

@RestController
public class LoginController{

	@Autowired
	private ConsumerRepository consumerRepository;
	
	@GetMapping("/signIn")
	public ResponseEntity<Consumer> getLoggedInCustomerDetailsHandler(Authentication auth){
		
		System.out.println(auth);
		
		Consumer cunsumer = consumerRepository.findByEmail(auth.getName()).orElseThrow(() -> new BadCredentialsException("Invalid Username or password"));
		
		return new ResponseEntity<>(cunsumer, HttpStatus.ACCEPTED);
		
		
	}

}
