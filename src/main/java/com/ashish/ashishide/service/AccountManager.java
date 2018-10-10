package com.ashish.ashishide.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ashish.ashishide.bo.UserBO;

@Component
public class AccountManager {
	
	@Autowired
	public AccountTools acctTools;

	public Boolean registerUser(UserBO user) {
		return acctTools.registerUser(user);
	}
	
	public Object findUsers(String key, String value) {
		return acctTools.findUsers(key, value);
	}
	
	public Boolean isUserAlreadyExistsByEmail(String emailId) {
		return acctTools.isUserExitByEmail(emailId);
	}
	

}
