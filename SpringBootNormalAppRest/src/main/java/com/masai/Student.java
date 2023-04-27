package com.masai;

public class Student {
	private int id;
	private String name;
	private int marks;
	private Address address;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}


	public Student(int id, String name, int marks, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
		this.address = address;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getMarks() {
		return marks;
	}


	public void setMarks(int marks) {
		this.marks = marks;
	}


//	@Override
//	public String toString() {
//		return "Student [id=" + id + ", name=" + name + ", marks=" + marks + "]";
//	}
//	
	
	
}
