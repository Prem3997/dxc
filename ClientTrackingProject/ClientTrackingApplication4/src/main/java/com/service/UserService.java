package com.service;

import com.model.User;

public interface UserService {
	public boolean addUser(User user);

	public boolean isValidUser(String userName, String password);

}
