package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Model.Customer;
import com.masai.Repository.CustomerRepository;


@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	public Customer registerCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public Customer getCustomerByEmail(String email) {
		Optional<Customer> opt = customerRepository.findByEmail(email);
		
		if(opt.isEmpty()) throw new RuntimeException("Not found");
		
		return opt.get();
 	}
	
	
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
}
