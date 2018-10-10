package com.ashish.ashishide.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.ashish.ashishide.bo.UserBO;

@Repository("mongoDAO")
public class MongoImpl implements MongoDAO{
	
	@Autowired
	private MongoOperations mongoOperations;

	/**
	 * Below method is to save user data to Mongo DB.
	 */
	@Override
	public Boolean registerUser(UserBO urb) {
		//save method is used to save the data to Mongo.
		mongoOperations.save(urb);
		return true;
	}

	@Override
	public List<UserBO> findUsers(String key, String value) {
		Query query = new Query();
		query.addCriteria(Criteria.where(key).is(value));
		List<UserBO> customer = mongoOperations.find(query, UserBO.class);
		return customer;
	}

	@Override
	public Object findUserByEmailId(String emailId) {
		return mongoOperations.find(new Query().addCriteria(Criteria.where("email").is(emailId)), UserBO.class);
	}

}
