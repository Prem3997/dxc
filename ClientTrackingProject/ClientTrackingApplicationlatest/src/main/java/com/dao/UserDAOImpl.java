package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	MongoTemplate template;

	@Override
	public boolean addUser(User user) {
		template.save(user);
		return true;
	}
	@Override
	public boolean isValidUser(String userName, String password) {
		System.out.println("is validuser dao CALLED");
		Query query = new Query();
		query.addCriteria(Criteria.where("userName").is(userName));
		query.addCriteria(Criteria.where("password").is(password));
		List<User> result = template.find(query, User.class, "user");
		System.out.println(result);
		if (result.size() == 0)
			return false;
		else
			return true;
	}
}
