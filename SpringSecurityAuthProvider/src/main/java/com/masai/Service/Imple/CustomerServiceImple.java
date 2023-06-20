package com.masai.Service.Imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Model.Customer;
import com.masai.Repository.CustomerRepository;
import com.masai.Service.CustomerService;

@Service
public class CustomerServiceImple implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer registerCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		Customer customer = customerRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Customer is not present") );
		return customer;
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

}
