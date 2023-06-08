package com.masai.DTO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.masai.Model.Consumer;
import com.masai.Repository.ConsumerRepository;

public class UserDetail implements UserDetailsService{
	@Autowired
	private ConsumerRepository consumerRepository;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Consumer consumer = consumerRepository.findByEmail(username).orElseThrow(() -> new BadCredentialsException("Invalid Username or password"));
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority( consumer.getRole())) ;
		
		return new User(consumer.getEmail(), consumer.getPossword(), authorities);
	}

}
