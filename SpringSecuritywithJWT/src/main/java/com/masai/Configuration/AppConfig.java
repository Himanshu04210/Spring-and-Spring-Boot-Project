package com.masai.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class AppConfig {

	@Bean
	public SecurityFilterChain projectSecurity(HttpSecurity http) throws Exception {
		
		
		
		return http.build();
	}
	
}
