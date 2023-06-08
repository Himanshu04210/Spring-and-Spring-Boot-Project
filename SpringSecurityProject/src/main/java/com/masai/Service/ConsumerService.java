package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Model.Consumer;
import com.masai.Repository.ConsumerRepository;

@Service
public class ConsumerService {

	@Autowired
	private ConsumerRepository consumerRepository;

	public List<Consumer> getAllCustomerDetails() {
		List<Consumer> consumers = consumerRepository.findAll();
		
		if(consumers.isEmpty()) throw new RuntimeException("No consumer present");
		
		return consumers;
	}
	
	public Consumer findConsumerByEmail(String email) {
		Optional<Consumer> opt = consumerRepository.findByEmail(email);
		
		if(opt.isEmpty()) throw new RuntimeException("No consumer present");
		
		return opt.get();
	}
	
	public Consumer registerConsumer(Consumer consumer) {
		Consumer saveConsumer = consumerRepository.save(consumer);
		return saveConsumer;
	}
	
	
}
