package com.example.coursify;

import java.util.ArrayList;

import com.example.coursify.model.Comment;
import com.example.coursify.model.Course;
import com.example.coursify.model.Professor;
import com.example.coursify.model.Student;
import com.example.coursify.model.User;

public class DummyServer implements Server {
	private final ArrayList<Course> coursesUser, coursesAvailable;

	public DummyServer() {
		coursesUser = new ArrayList<Course>();
		coursesUser.add(new Course("Vorlesung 1", "Prof X."));
		coursesUser.add(new Course("Vorlesung 2", "Prof Y."));
		coursesUser.add(new Course("Vorlesung 3", "Prof Z."));

		coursesAvailable = new ArrayList<Course>();
		coursesAvailable.add(new Course("Vorlesung 1", "Prof X."));
		coursesAvailable.add(new Course("Vorlesung 2", "Prof Y."));
		coursesAvailable.add(new Course("Vorlesung 3", "Prof Z."));
		coursesAvailable.add(new Course("Vorlesung 4", "Prof X."));
		coursesAvailable.add(new Course("Vorlesung 5", "Prof Y."));
		coursesAvailable.add(new Course("Vorlesung 6", "Prof Z."));
		coursesAvailable.add(new Course("Vorlesung 7", "Prof X."));
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
	public ArrayList<Comment> getComments(Course lecture) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Course> getUserLectures(User user) {
		return coursesUser;
	}

	@Override
	public ArrayList<Course> getAvailableLectures(User user) {

		return coursesAvailable;
	}

	@Override
	public void removeUserLecture(User user, Course lecture) {
		coursesUser.remove(lecture);
	}

	@Override
	public void addUserLecture(User user, Course lecture) {
		coursesUser.add(lecture);
	}
}
