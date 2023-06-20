package com.masai.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

public class AppConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public SecurityFilterChain projectSecurity(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests()
		.requestMatchers(HttpMethod.POST, "/customers").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.csrf().disable()
		.formLogin()
		.and()
		.httpBasic();
		
		return http.build();
	}
}
