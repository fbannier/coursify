package com.example.coursify.model;


public class Professor extends User {

	public Professor(String name) {
		super(name);
	}

	@Override
	public String getRole() {
		return "Prof";
	}

}
