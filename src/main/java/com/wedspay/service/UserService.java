package com.wedspay.service;

import java.util.List;

import com.wedspay.entity.Person;
import com.wedspay.entity.User;

public interface UserService {
	public void saveUser(User user);

	public User getUserByMobileNo(String mobile);
	
	public User getUserByUserName(String userName);

	public List<Person> getPersonsList(String userName);
}
