package com.masai.Service;

import java.util.List;

import com.masai.Model.Customer;

public interface CustomerService {
	public Customer registerCustomer(Customer customer);
	
	public Customer getCustomerByEmail(String email);
	public List<Customer> getAllCustomer();
}
