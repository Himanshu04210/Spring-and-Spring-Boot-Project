package com.masai.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Model.Customer;
import com.masai.Repository.CustomerRepository;

@RestController
public class LogginController {
	
	private CustomerRepository customerRepository;
	
	
	@GetMapping("signIn")
	public ResponseEntity<Customer> logInCustomerDetailHandler(Authentication authentication) {
		
		String username = authentication.getName();
		
		Customer customer = customerRepository.findByEmail(username).orElseThrow(() -> new BadCredentialsException("Email is not matched"));
		
		return new ResponseEntity<Customer>(customer, HttpStatus.FOUND);
				
		
		
	}
	

}
