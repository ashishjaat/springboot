package com.ashish.ashishide.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashish.ashishide.service.AccountManager;
import com.ashish.ashishide.bo.UserBO;


@RestController
public class UserRegistrationService {
	
	@Autowired
	public AccountManager acctManager;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String register() {
		return "Hello world...!";
	}
	
	/**
	 * Below method is used to Register the user.
	 * User enters details in the form and we store them in Monog DB.
	 * Once data is saved to Mongo db, below method return CustomerBO object back as an output. becuase we 
	 * are returning CustomerBO object to ResponseBody.
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/user/registration", method = RequestMethod.POST)
	@ResponseBody
	public Object addUser(@RequestBody UserBO user) {
		//Connect to Mongo DB and store the details.
		if (acctManager.isUserAlreadyExistsByEmail(user.getEmail())) {
			return "User with emailId "+user.getEmail()+" is already Exists...!!! Try with another email id";
		} 
		if(acctManager.registerUser(user)) {
			System.out.println("User "+user.getFirstName()+" is Registered successfully");
		} else {
			System.out.println("Went Some thing worng with the user "+user.getFirstName());
		}
	return user;
	}
	
	/**
	 * Finding user based on userId in the service url i.e /user/4572/invoke?userId=9999
	 * @PathVariable is used to get value from url - 4572 is output.
	 * @RequestParam is used to get request param, - for userId param output will be 9999
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/user/{key}/{value}", method = RequestMethod.GET)
	@ResponseBody
	public List<UserBO> findUsers(@PathVariable String key,@PathVariable String value) {
		return (List<UserBO>) acctManager.findUsers(key, value);
		
	}
	
}
