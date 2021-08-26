package com.example.demo.controller;
 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {


	@Autowired
	EmployeeService es ;
	
	// for inserting data  
	@PostMapping("")
	public String add(@RequestBody Employee d) {
		            
		return es.add(d);
	}
	// All employee data
	@GetMapping("")
	public List<Employee> getInfo() {	
		System.out.println("Hi---->");
		return es.getAllData();
	}
	// Id Specific employee data 
	@GetMapping("/{id}")
	public String getInfo(@PathVariable int id) {	
		return es.getDataById(id);
	}

	@DeleteMapping("/{id}")
	public String delData(@PathVariable int id) {
		return es.deletedUser(id);
	}


	
}
