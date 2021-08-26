package com.example.demo.service;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService  {

	@Autowired 
	EmployeeRepository repo;
	
	
	public String add(Employee d) {
		Random ran = new Random();
		long tk = ran.nextLong();
		d.setToken(""+tk) ;
		repo.save(d);
		return d.getToken();
	}
	

	public List<Employee> getAllData(){
		System.out.println("From Find");
		return repo.findAll();
	}
	
	public String getDataById(int id) {
		Employee ep = repo.findById(id).get();
		return ep.getName();
	}
	
	public String deletedUser(int id) {
		Employee data = repo.findById(id).get();
		repo.deleteById(id);
		return "deleted : "+ data.toString();
	}
	
}
