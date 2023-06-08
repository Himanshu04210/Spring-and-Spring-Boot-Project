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

import com.masai.Model.Consumer;
import com.masai.Service.ConsumerService;

@RestController
public class ConsumerController {

	@Autowired
	private ConsumerService consumerService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@PostMapping("/consumers")
	public ResponseEntity<Consumer> registerConsumer(@RequestBody Consumer consumer) {
		consumer.setPossword(passwordEncoder.encode(consumer.getPossword()));
		
		Consumer savedConsumer = consumerService.registerConsumer(consumer);
		return new ResponseEntity<>(savedConsumer, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/consumers/{email}")
	public ResponseEntity<Consumer> getCustomerByEmailHandler(@PathVariable("email") String email){
		
		
		Consumer consumers = consumerService.findConsumerByEmail(email);
		
		return new ResponseEntity<>(consumers,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/consumers")
	public ResponseEntity<List<Consumer>> getAllConsumer() {

		List<Consumer> consumers = consumerService.getAllCustomerDetails();
		
		return new ResponseEntity<>(consumers,HttpStatus.ACCEPTED);
		
	}
	
	
	
	
}
