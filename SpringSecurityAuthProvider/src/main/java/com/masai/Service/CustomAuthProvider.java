package com.masai.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.masai.Model.Customer;
import com.masai.Repository.CustomerRepository;


@Service
public class CustomAuthProvider implements AuthenticationProvider {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String userName = authentication.getName();
		
		String pswrd = authentication.getCredentials().toString();
		
		Customer customer = customerRepository.findByEmail(userName).orElseThrow(() -> new RuntimeException("email not matched"));
		
		if(passwordEncoder.matches(customer.getPassword(), pswrd)) {
			List<GrantedAuthority> authorities = new ArrayList<>();
			return new UsernamePasswordAuthenticationToken(customer, pswrd, authorities);
		}
		
		else throw new BadCredentialsException("password is not matched");
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
