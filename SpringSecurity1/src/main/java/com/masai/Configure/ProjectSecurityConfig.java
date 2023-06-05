package com.masai.Configure;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class ProjectSecurityConfig {

	public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception {
		
		
		http.authorizeHttpRequests( (auth)->auth
				.requestMatchers("/masai/welcomeP").authenticated()
				.requestMatchers("/masai/welcome").permitAll()
		).httpBasic();

		return http.build();
	}
	
}
