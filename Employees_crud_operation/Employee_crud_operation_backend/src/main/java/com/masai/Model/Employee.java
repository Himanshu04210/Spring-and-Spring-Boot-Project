package com.masai.Model;

public class Employee {
	private int empId;
	private String empName;
	private int salary;
	
	//Constructors
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Employee(int empId, String empName, int salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
	}


	//Getter and setter

	public int getEmpId() {
		return empId;
	}



	public void setEmpId(int empId) {
		this.empId = empId;
	}



	public String getEmpName() {
		return empName;
	}



	public void setEmpName(String empName) {
		this.empName = empName;
	}



	public int getDepartment() {
		return salary;
	}



	public void setDepartment(int salary) {
		this.salary = salary;
	}



	@Override
	public String toString() {
		return "[empId=" + empId + ", empName=" + empName + ", department=" + salary + "]";
	}
	
	
	
	
	
}
