package com.example.coursify;

import com.example.coursify.model.User;

//singleton for easy access to stuff like server and user
public class Connection {
	private static Connection instance = new Connection();

	private final Server mServer;
	private User mUser;

	private Connection() {
		mServer = new DummyServer();
		mUser = null;
	}

	public static Connection getInstance() {
		return instance;
	}

	public Server getServer() {
		return mServer;
	}

	public User getUser() {
		return mUser;
	}

	public void setUser(User user) {
		mUser = user;
	}

}
