package com.ashish.ashishide.dao;

import java.util.List;

import com.ashish.ashishide.bo.UserBO;

public interface MongoDAO {
	
	/**
	 * Implementation of below method is available @MongoImpl
	 * User entered details in registration form is stored in Mongo db.
	 * @param urb
	 * @return
	 */
	Boolean registerUser(UserBO urb);
	
	/**
	 * It finds the user from Mongo DB and returns the list of customers.
	 * @param userId
	 * @return
	 */
	List<UserBO> findUsers(String key, String value); 
	
	/**
	 * Finding user based on emailId.
	 * @param emailId
	 * @return
	 */
	Object findUserByEmailId(String emailId);
	
}
