package com.masai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootPraticeAppApplication /*extends SpringBootServletInitializer*/ {

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(SpringBootPraticeAppApplication.class);
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootPraticeAppApplication.class, args);
	}

}
