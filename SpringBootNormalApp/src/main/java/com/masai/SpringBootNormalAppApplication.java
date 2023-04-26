package com.masai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootNormalAppApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootNormalAppApplication.class, args);
		A a1 = ctx.getBean("a", A.class);
		a1.funA();
	}

}
