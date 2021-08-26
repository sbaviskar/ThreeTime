package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employ {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id ;
	String name ;
	String token;

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + "]";
	}
	public String getToken() {
		return this.token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Employ() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employ(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
}
