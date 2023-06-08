package com.masai.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppConfig {
	
	@Bean
	public SecurityFilterChain securityConfiguration(HttpSecurity http) throws Exception{
		
		http
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers(HttpMethod.POST, "/consumers")
		.permitAll()
		.requestMatchers(HttpMethod.GET ,"/consumers").hasRole("ADMIN")
		.requestMatchers(HttpMethod.GET,"/consumers/**").hasAnyRole("ADMIN","USER")
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
		
		
		return http.build();
	}
}
