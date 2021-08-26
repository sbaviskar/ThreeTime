package com.example.demo;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployController {

	@Autowired
	EmployRepository repo;
	
	// for inserting data  
	@PostMapping("/employ")
	public String add(@RequestBody Employ d) {
		Random ran = new Random();
		long tk = ran.nextLong();
		d.token = ""+tk ;
		repo.save(d);
		return d.token;
	}
	// All employ data
	@GetMapping("/employ")
	public List<Employ> getInfo() {
		System.out.println("TestPrint");	
		return repo.findAll();
	}
	// Id Specific employ data 
	@GetMapping("/employ/{id}")
	public String getInfo(@PathVariable int id) {
		Employ ep = repo.findById(id).get();
		System.out.println("TestPrint");	
		return ep.name;
	}

	@DeleteMapping("/employ/{id}")
	public String delData(@PathVariable int id) {
		Employ data = repo.findById(id).get();
		System.out.println(data);
		repo.deleteById(id);
		return "deleted "+ data.toString();
	}


	
}
