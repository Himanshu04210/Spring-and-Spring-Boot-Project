package com.masai.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Model.Employee;

import jakarta.annotation.PostConstruct;

@RestController
@CrossOrigin(origins = "*")
public class EmployeeService {
	
	private List<Employee> employees = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		Employee emp1 = new Employee(1001, "Susheel", 20000, "Accounts" );
		Employee emp2 = new Employee(1002, "John Doe", 290100, "Accounts");
		Employee emp3 = new Employee(1003, "Spark", 12000, "HR" );
		Employee emp4 = new Employee(1004, "Joe", 901900, "Product" );
		Employee emp5 = new Employee(1005, "Venu", 190300, "HR");
		Employee emp6 = new Employee(1006, "Szam", 120050, "Product");
		Employee emp7 = new Employee(1007, "Priyanshu", 190990, "marketing");
		Employee emp8 = new Employee(1008, "Aman", 20000, "marketing");
		Employee emp9 = new Employee(1009, "Amit", 32000, "Sales");
		Employee emp10 = new Employee(1010, "Pankaj", 24000, "Sales");
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		employees.add(emp4);
		employees.add(emp5);
		employees.add(emp6);
		employees.add(emp7);
		employees.add(emp8);
		employees.add(emp9);
		employees.add(emp10);
	}
	
	
	@GetMapping(value = "/employees")
	public List<Employee> getAllEmployeeData(){
		return employees;
	}
	
	@GetMapping("/employees/{empId}")
	public Employee getEmployeeByIdHandler(@PathVariable Integer empId) {
		
		for(Employee e : employees) {
			if(e.getEmpId().equals(empId)) {
				return e;
			}
		}
		throw new IllegalArgumentException("No employee present");
	}
	
	@PutMapping(value = "/employees/{empId}")
	public String updateEmployeeValueByEmpId(@PathVariable Integer empId, @RequestBody Employee employee) {
		for(Employee e : employees) {
			if(e.getEmpId().equals(empId)) {
				e.setDepartment(employee.getDepartment());
				e.setEmpName(employee.getEmpName());
				e.setSalary(employee.getSalary());
				return "Employee data updated seccessfully" + employee;
			}
		}
		throw new IllegalArgumentException("No employee present");
	}
	
	@PostMapping("/employees")
	public String saveEmployeeHandler(@RequestBody Employee employee) {
		employees.add(employee);
		return "Employee added succesfully " + employee;
	}
	
	
	
	
	@DeleteMapping(value = "/employees/{empId}")
	public String deleteEmployeeHandler(@PathVariable Integer empId) {
		for(Employee e : employees) {
			if(e.getEmpId().equals(empId)) {
				employees.remove(e);
				return "Employee Deleted Successfully";
			}
		}
		throw new RuntimeException("No employee present");
		
	}
	
	
}
