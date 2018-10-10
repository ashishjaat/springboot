package com.ashish.ashishide.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ashish.ashishide.bo.UserBO;
import com.ashish.ashishide.dao.MongoDAO;

@Component
public class AccountTools {
	
	@Autowired
	public MongoDAO mongoDAO;

	public Boolean registerUser(UserBO user) {
		return mongoDAO.registerUser(user);
	}
	
	public Object findUsers(String key, String value) {
		return mongoDAO.findUsers(key, value);
	}

	
	@SuppressWarnings("unchecked")
	public Boolean isUserExitByEmail(String emailId) {
		List<UserBO> customer = (List<UserBO>) mongoDAO.findUserByEmailId(emailId);
		System.out.println(customer.toString());
		if(null == customer || customer.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	
}
