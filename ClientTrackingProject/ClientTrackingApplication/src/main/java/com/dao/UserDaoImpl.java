package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.model.User;
@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	MongoTemplate template;
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		if(isValidUser(user.getUserName(), user.getPassword()))
			return false;
		else {
			template.save(user);
			return true;
		}
	}

	@Override
	public boolean isValidUser(String userName, String password) {
		// TODO Auto-generated method stub
		System.out.println("DAO CALLED");
		Query query=new Query();
		query.addCriteria(Criteria.where("userName").is(userName));
		query.addCriteria(Criteria.where("password").is(password));
		List<User> result=template.find(query, User.class, "user");
		System.out.println(result);
		if(result==null)
			return false;
		else
			return true;
	}
}
