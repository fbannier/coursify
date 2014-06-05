package com.example.coursify.model;


public abstract class User {

	private final String Name;

	protected User(String name) {
		Name = name;
	}

	public abstract String getRole();

	public String getName() {
		return Name;
	}
}
