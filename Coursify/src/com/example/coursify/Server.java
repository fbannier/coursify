package com.example.coursify;

import java.util.ArrayList;

import com.example.coursify.model.Comment;
import com.example.coursify.model.Lecture;
import com.example.coursify.model.User;

public interface Server {
	public Boolean isConnected();

	public User login(String username, String password);

	public ArrayList<Lecture> getLectures(String username, String password);

	public ArrayList<Comment> getComments(Lecture lecture);
}
