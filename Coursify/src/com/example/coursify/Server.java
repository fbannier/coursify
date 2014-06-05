package com.example.coursify;

import java.util.ArrayList;

import com.example.coursify.model.Comment;
import com.example.coursify.model.Course;
import com.example.coursify.model.User;

public interface Server {
	public Boolean isConnected();

	public User login(String username, String password);

	public ArrayList<Course> getUserLectures(User user);

	public ArrayList<Course> getAvailableLectures(User user);

	public ArrayList<Comment> getComments(Course lecture);

	public void removeUserLecture(User user, Course lecture);

	public void addUserLecture(User user, Course lecture);
}
