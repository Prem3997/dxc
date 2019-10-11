package com.dxc.userproject.dao;

import com.dxc.userproject.model.UserForm;

public interface UserFormDao {
	public void addUser(UserForm userForm);
	public boolean isValidUser(String userName,String password);
}
