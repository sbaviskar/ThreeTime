package com.example.demo.controller;
 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employ;
import com.example.demo.service.EmployService;

@RestController
public class EmployController {


	@Autowired
	EmployService es ;
	
	// for inserting data  
	@PostMapping("/employ")
	public String add(@RequestBody Employ d) {
		            
		return es.add(d);
	}
	// All employ data
	@GetMapping("/employ")
	public List<Employ> getInfo() {	
		return es.getAllData();
	}
	// Id Specific employ data 
	@GetMapping("/employ/{id}")
	public String getInfo(@PathVariable int id) {	
		return es.getDataById(id);
	}

	@DeleteMapping("/employ/{id}")
	public String delData(@PathVariable int id) {
		return es.deletedUser(id);
	}


	
}
