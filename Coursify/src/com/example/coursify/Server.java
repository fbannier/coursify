package com.example.coursify;

import java.util.ArrayList;

import com.example.coursify.model.Comment;
import com.example.coursify.model.Lecture;
import com.example.coursify.model.User;

public interface Server {
	public Boolean isConnected();

	public User login(String username, String password);

	public ArrayList<Lecture> getUserLectures(User user);

	public ArrayList<Lecture> getAvailableLectures(User user);

	public ArrayList<Comment> getComments(Lecture lecture);

	public void removeUserLecture(User user, Lecture lecture);

	public void addUserLecture(User user, Lecture lecture);
}
