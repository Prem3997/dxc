package com.dao;

import com.model.User;

public interface UserDAO {
	public boolean addUser(User user);

	public boolean isValidUser(String userName, String password);

}
