package com.example.demo.service;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employ;
import com.example.demo.repository.EmployRepository;

@Service
public class EmployService  {

	@Autowired
	EmployRepository repo;
	
	
	public String add(Employ d) {
		Random ran = new Random();
		long tk = ran.nextLong();
		d.setToken(""+tk) ;
		repo.save(d);
		return d.getToken();
	}
	

	public List<Employ> getAllData(){
		
		return repo.findAll();
	}
	
	public String getDataById(int id) {
		Employ ep = repo.findById(id).get();
		return ep.getName();
	}
	
	public String deletedUser(int id) {
		Employ data = repo.findById(id).get();
		repo.deleteById(id);
		return "deleted : "+ data.toString();
	}
	
}
