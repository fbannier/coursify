package com.example.coursify;

import java.util.ArrayList;

import com.example.coursify.model.Comment;
import com.example.coursify.model.Lecture;
import com.example.coursify.model.Professor;
import com.example.coursify.model.Student;
import com.example.coursify.model.User;

public class DummyServer implements Server {
	private final ArrayList<Lecture> coursesUser, coursesAvailable;

	public DummyServer() {
		coursesUser = new ArrayList<Lecture>();
		coursesUser.add(new Lecture("Vorlesung 1", "Prof X."));
		coursesUser.add(new Lecture("Vorlesung 2", "Prof Y."));
		coursesUser.add(new Lecture("Vorlesung 3", "Prof Z."));

		coursesAvailable = new ArrayList<Lecture>();
		coursesAvailable.add(new Lecture("Vorlesung 1", "Prof X."));
		coursesAvailable.add(new Lecture("Vorlesung 2", "Prof Y."));
		coursesAvailable.add(new Lecture("Vorlesung 3", "Prof Z."));
		coursesAvailable.add(new Lecture("Vorlesung 4", "Prof X."));
		coursesAvailable.add(new Lecture("Vorlesung 5", "Prof Y."));
		coursesAvailable.add(new Lecture("Vorlesung 6", "Prof Z."));
		coursesAvailable.add(new Lecture("Vorlesung 7", "Prof X."));
	}

	@Override
	public Boolean isConnected() {
		return true;
	}

	@Override
	public User login(String username, String password) {
		if (!password.equals("bla"))
			return null;

		if (username.equals("stu"))
			return new Student("stu");
		if (username.equals("prof"))
			return new Professor("prof");

		return null;
	}

	@Override
	public ArrayList<Comment> getComments(Lecture lecture) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Lecture> getUserLectures(User user) {
		return coursesUser;
	}

	@Override
	public ArrayList<Lecture> getAvailableLectures(User user) {

		return coursesAvailable;
	}

	@Override
	public void removeUserLecture(User user, Lecture lecture) {
		coursesUser.remove(lecture);
	}

	@Override
	public void addUserLecture(User user, Lecture lecture) {
		coursesUser.add(lecture);
	}
}
