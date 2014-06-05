package com.example.coursify.model;

import java.util.ArrayList;

import android.os.Parcel;

public class Student extends User {

	public Student(String name, ArrayList<Lecture> lectures) {
		super(name, lectures);
	}

	@Override
	public String getRole() {
		return "Student";
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel arg0, int arg1) {
		// TODO Auto-generated method stub

	}

}
