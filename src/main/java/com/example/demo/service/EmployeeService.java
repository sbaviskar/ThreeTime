package com.example.demo.service;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService  {

	@Autowired 
	EmployeeRepository repo;
	
	
	public Employee add(Employee d) {
		Random ran = new Random();
		long tk = ran.nextLong();
		d.setToken(""+tk) ;
		repo.save(d);
		return d;
	}
	

	public List<Employee> getAllData(){
		System.out.println("From Find");
		return repo.findAll();
	}
	
	public Employee getDataById(int id) {
		Employee ep = repo.findById(id).get();
		return ep;
	}
	
	public Employee deletedUser(int id) {
		Employee data = repo.findById(id).get();
		repo.deleteById(id);
		return data;
	}
	
}
