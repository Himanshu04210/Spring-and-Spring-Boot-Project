package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Model.Customer;
import com.masai.Service.CustomerService;

@RestController

public class MainController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/welcome")
	public ResponseEntity<String> welcome(){
		
	 return new ResponseEntity<String>("Welcome to Masai App without security",HttpStatus.ACCEPTED);

	}
	
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {
			customer.setPassword(passwordEncoder.encode(customer.getPassword()));
			Customer savedCustomer = customerService.registerCustomer(customer);
			
			return new ResponseEntity<Customer>(savedCustomer, HttpStatus.CREATED);
	}
	
	@GetMapping("/customers/{email}")
	public ResponseEntity<Customer> getCustomerByEmail(@PathVariable("email") String email) {
			Customer customer = customerService.getCustomerByEmail(email);
			
			return new ResponseEntity<Customer>(customer, HttpStatus.FOUND);
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getCustomerByEmail() {
			List<Customer> customers = customerService.getAllCustomers();
			
			return new ResponseEntity<>(customers, HttpStatus.OK);
	}
	
}
