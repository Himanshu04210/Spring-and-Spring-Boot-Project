package com.skumar.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

	@Autowired
	JdbcTemplate courseRepo;
	
	
	private static String INSERT_QUERY = 
			"""
				insert into course (id,name,author)
				values (1,'Java','Ratan');
			""";

	
	private static String DELETE_QUERY = 
			"""
				delete from course where id = ?;
			""";
	
	
	private static String SELECT_QUERY = 
			"""
				select from course where id = ?;
			""";
	
	public void insert(Course course) {
		courseRepo.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());
	}
	
	
	public void delete(long id) {
		courseRepo.update(DELETE_QUERY,id);
	}
	
	public Course selectQuery(long id) {
		return courseRepo.queryForObject(SELECT_QUERY,new BeanPropertyRowMapper<>(Course.class), id);
	}
}
