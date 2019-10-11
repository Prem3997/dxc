package com.dxc.userproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dxc.userproject.dbconnection.DbConnection;
import com.dxc.userproject.model.UserForm;

public class userFormDaoImpl implements UserFormDao {
	Connection connection=DbConnection.getConnection();
	private static final String ADD_USER="Insert into User values(?,?,?,?,?)";
	private static final String FETCH_USER="Select * from user where userName=? AND password=?";
	@Override
	public void addUser(UserForm userForm) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(ADD_USER);
			preparedStatement.setString(1, userForm.getUserName());
			preparedStatement.setString(2, userForm.getPassword());
			preparedStatement.setString(3, userForm.getFullName());
			preparedStatement.setString(4, userForm.getGender());
			preparedStatement.setString(5,userForm.getQualification());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public boolean isValidUser(String userName, String password) {
		// TODO Auto-generated method stub
		boolean isValidUser=false;
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(FETCH_USER);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			ResultSet resultSet =preparedStatement.executeQuery();
			if(resultSet.next())
				isValidUser=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isValidUser;
	}

}
