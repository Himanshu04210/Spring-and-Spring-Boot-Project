package com.skumar.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner{

	
	@Autowired
	private CourseJdbcRepository courseRepo;
	
	@Override
	public void run(String... args) throws Exception {
		courseRepo.insert(new Course(1,"Spring boot","Ratan"));
		courseRepo.insert(new Course(2,"AWS","Kapil"));
		courseRepo.delete(1);
		courseRepo.selectQuery(2);
	}

}
