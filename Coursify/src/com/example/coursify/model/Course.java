package com.example.coursify.model;

public class Course {
	private String name;
	private String prof;

	public Course(String name, String prof) {
		this.name = name;
		this.prof = prof;
	}

	public String getName() {
		return name;
	}

	public String getProf() {
		return prof;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProf(String prof) {
		this.prof = prof;
	}
}
