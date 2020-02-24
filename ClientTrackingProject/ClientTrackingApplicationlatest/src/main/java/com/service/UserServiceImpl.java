package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDAO;
import com.model.User;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO userdao;
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return userdao.addUser(user);
	}

	@Override
	public boolean isValidUser(String userName, String password) {
		// TODO Auto-generated method stub
		System.out.println("Service Called");
		return userdao.isValidUser(userName, password);
	}

}
