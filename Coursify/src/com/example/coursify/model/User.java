package com.example.coursify.model;

import java.util.ArrayList;

import android.os.Parcelable;

//implement parcelable to pass user in intents between activities
public abstract class User implements Parcelable {

	private final String Name;
	private ArrayList<Lecture> lectures;

	protected User(String name, ArrayList<Lecture> lectures) {
		Name = name;
		setLectures(lectures);

	}

	public ArrayList<Lecture> getLectures() {
		return lectures;
	}

	public void setLectures(ArrayList<Lecture> lectures) {
		this.lectures = lectures;
	}

	public User addLecture(Lecture lecture) {
		lectures.add(lecture);

		return this; // method chaining
	}

	public abstract String getRole();

	public String getName() {
		return Name;
	}
}
