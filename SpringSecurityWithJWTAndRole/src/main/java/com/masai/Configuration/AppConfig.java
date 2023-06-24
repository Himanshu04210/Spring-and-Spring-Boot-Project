package com.masai.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class AppConfig {

	
	public  SecurityFilterChain securityConfigurationo(HttpSecurity http) throws Exception {
		
		http
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers(HttpMethod.POST, "/customers").permitAll()
		.requestMatchers(HttpMethod.GET, "/customers").hasRole("ADMIN")
		.requestMatchers(HttpMethod.GET, "/customers/**").hasAnyRole("ADMIN", "USER")
		.anyRequest().authenticated()
		.and()
		.addFilterAfter(new JwtTokenGeneratorFilter(), BasicAuthenticationFilter.class)
		.addFilterBefore(new JwtTokenValidatorFilter(), BasicAuthenticationFilter.class)
		.formLogin()
		.and()
		.httpBasic();
		
		return http.build();
	}
	
	
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
