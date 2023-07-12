package com.masai;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.JobLauncherApplicationRunner;

@SpringBootApplication
public class SpringBootPraticeAppApplication /*extends SpringBootServletInitializer*/ implements ApplicationRunner{

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(SpringBootPraticeAppApplication.class);
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootPraticeAppApplication.class, args);
	}
	
	@Override
	public void run(ApplicationArguments args0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Welcome to spring boot practice application app");
	}

}
