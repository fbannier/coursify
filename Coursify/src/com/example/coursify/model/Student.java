package com.example.coursify.model;


public class Student extends User {

	public Student(String name) {
		super(name);
	}

	@Override
	public String getRole() {
		return "Student";
	}

}
