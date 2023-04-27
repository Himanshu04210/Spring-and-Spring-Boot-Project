package com.masai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @RequestMapping("/hii")
    @ResponseBody
    public String getMessage() {
        return "Welcome to my first rest api";
    }
    
    
    @RequestMapping("/student")
    @ResponseBody
    public Student getStudent() {
    	return new Student(10, "Ram", 580, new Address("Orai", "Hamirpur"));
    }
    
    @RequestMapping("/studentList")
    @ResponseBody
    public List<Student> getStudents() {
    	List<Student> list = new ArrayList<>();
    	list.add(new Student(1, "Radhe", 590, new Address("Orchha", "Kanpur")));
    	list.add(new Student(2, "Ram", 230, new Address("Jhanshi", "Mohoba")));
    	list.add(new Student(3, "yashoda", 450, new Address("Chitrkoot", "Banda")));
    	list.add(new Student(4, "Nand", 430, new Address("Varansi", "Prayagraj")));
    	list.add(new Student(5, "Balram", 450, new Address("Delhi", "Vrandhavan")));
    	list.add(new Student(6, "Krishna", 460, new Address("jaypur", "Kashi")));
    	
    	return list;
    }
    
    
    @RequestMapping("/studentMap")
    @ResponseBody
    public Map<Integer, Student> getStudentsMap() {
    	Map<Integer, Student> map = new HashMap<>();
    	
    	
    	map.put(1, new Student(1, "Radhe", 590, new Address("Orchha", "Kanpur")));
    	map.put(2, new Student(2, "Ram", 230, new Address("Jhanshi", "Mohoba")));
    	map.put(3, new Student(3, "yashoda", 450, new Address("Chitrkoot", "Banda")));
    	map.put(4, new Student(4, "Nand", 430, new Address("Varansi", "Prayagraj")));
    	map.put(5, new Student(5, "Balram", 450, new Address("Delhi", "Vrandhavan")));
    	map.put(6, new Student(6, "Krishna", 460, new Address("jaypur", "Kashi")));
    	
    	return map;
    	
    	
    	
    }
    
    @RequestMapping("/studentMapInt")
    @ResponseBody
    public Map<Student, Integer> getStudentsMapInt() {
    	Map<Student, Integer> map = new HashMap<>();
    	
    	
    	map.put(new Student(1, "Radhe", 590, new Address("Orchha", "Kanpur")), 1);
    	map.put(new Student(2, "Ram", 230, new Address("Jhanshi", "Mohoba")), 2);
    	map.put(new Student(3, "yashoda", 450, new Address("Chitrkoot", "Banda")), 3);
    	map.put(new Student(4, "Nand", 430, new Address("Varansi", "Prayagraj")), 4);
    	map.put(new Student(5, "Balram", 450, new Address("Delhi", "Vrandhavan")), 5);
    	map.put(new Student(6, "Krishna", 460, new Address("jaypur", "Kashi")), 6);
    	
    	return map;
    	
    	
    	
    }
    
	
}
