package com.masai.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Model.Employee;

import jakarta.annotation.PostConstruct;

@RestController
public class EmployeeService {
	
	private List<Employee> employees = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		Employee emp1 = new Employee(1001, "Susheel", 20000 );
		Employee emp2 = new Employee(1002, "John Doe", 290100 );
		Employee emp3 = new Employee(1003, "Spark", 12000 );
		Employee emp4 = new Employee(1004, "Joe", 901900 );
		Employee emp5 = new Employee(1005, "Venu", 190300 );
		Employee emp6 = new Employee(1006, "Szam", 120050 );
		Employee emp7 = new Employee(1007, "Priyanshu", 190990 );
		Employee emp8 = new Employee(1008, "Aman", 20000 );
		Employee emp9 = new Employee(1009, "Amit", 32000 );
		Employee emp10 = new Employee(1010, "Pankaj", 24000 );
		employees = Arrays.asList(emp1, emp2, emp3, emp4, emp5, emp6, emp7, emp8, emp9, emp10);
		
	}
	
	
	@GetMapping(value = "/employees")
	public List<Employee> getData() {
			return employees;
	}
	
	@PutMapping(value = "/employee{empId}")
	public Employee updateEmployeeValueByEmpId(@PathVariable Integer empId, @RequestBody Employee employee) {
		
		
		return employee;
	}
	
	
	
}
