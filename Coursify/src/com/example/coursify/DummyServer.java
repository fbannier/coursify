package com.example.coursify;

import java.util.ArrayList;

import com.example.coursify.model.Comment;
import com.example.coursify.model.Lecture;
import com.example.coursify.model.Professor;
import com.example.coursify.model.Student;
import com.example.coursify.model.User;

public class DummyServer implements Server {
	@Override
	public Boolean isConnected() {

		return true;
	}

	@Override
	public User login(String username, String password) {
		if (!password.equals("bla"))
			return null;

		if (username.equals("stu"))
			return new Student("stu", getLectures(username, password));
		if (username.equals("prof"))
			return new Professor("prof", getLectures(username, password));

		return null;
	}

	@Override
	public ArrayList<Lecture> getLectures(String username, String password) {
		ArrayList<Lecture> lectures = new ArrayList<Lecture>();
		lectures.add(new Lecture("Vorlesung 1"));
		lectures.add(new Lecture("Vorlesung 2"));
		lectures.add(new Lecture("Vorlesung 3"));
		lectures.add(new Lecture("Vorlesung 4"));
		lectures.add(new Lecture("Vorlesung 5"));
		lectures.add(new Lecture("Vorlesung 6"));
		lectures.add(new Lecture("Vorlesung 7"));

		return lectures;
	}

	@Override
	public ArrayList<Comment> getComments(Lecture lecture) {
		// TODO Auto-generated method stub
		return null;
	}
}
