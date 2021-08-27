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
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {


	@Autowired
	EmployeeService es ;
	
	// for inserting data  
	@PostMapping("")
	public Employee add(@RequestBody Employee d) {
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
	public Employee  getInfo(@PathVariable int id) {	
		Employee emp =  es.getDataById(id);
		if(emp == null)
			throw new UserException("id "+ id);
		else
			System.out.println(emp.toString());
		return emp;
		
	}

	@DeleteMapping("/{id}")
	public Employee delData(@PathVariable int id) {
		return es.deletedUser(id);
	}


	
}
