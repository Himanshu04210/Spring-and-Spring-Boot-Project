package com.masai.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.Model.Customer;
import com.masai.Repository.CustomerRepository;

@Service
public class CustomerUserDetailService implements UserDetailsService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Customer> opt = customerRepository.findByEmail(username);
		
		if(opt.isEmpty()) {
			throw new BadCredentialsException("No customer is present with "+ username);
		}
		
		Customer customer = opt.get();
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		//authorities.add(new SimpleGrantedAuthority(customer.getRoll));
		
		return new User(customer.getEmail(), customer.getPassword(), authorities);
	}

}
