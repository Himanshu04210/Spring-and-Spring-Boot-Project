package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Model.Customer;
import com.masai.Service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/hello")
	public String hello() {
		return "welcome to the app";
	}
	
	
	@PostMapping("/customers")
	public ResponseEntity<?> registerCustomer(@RequestBody Customer customer) {
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		Customer savedCustomer = customerService.registerCustomer(customer);
		
		return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/customers")
	public ResponseEntity<?> getCustomerByEmail(@RequestParam("email") String email) {
		Customer customer = customerService.getCustomerByEmail(email);
		
		return new ResponseEntity<>(customer, HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/customers")
	public ResponseEntity<List<?>> getCustomerByEmail() {
		List<Customer> customers = customerService.getAllCustomer();
		
		return new ResponseEntity<>(customers, HttpStatus.CREATED);
		
	}
	
	
}
