package com.example.coursify.model;

import java.util.ArrayList;

import android.os.Parcel;

public class Professor extends User {

	public Professor(String name, ArrayList<Lecture> lectures) {
		super(name, lectures);
	}

	@Override
	public String getRole() {
		return "Prof";
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub

	}

}
