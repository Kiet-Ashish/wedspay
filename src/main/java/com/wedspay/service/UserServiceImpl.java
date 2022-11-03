package com.wedspay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wedspay.dao.UserDAO;
import com.wedspay.entity.Person;
import com.wedspay.entity.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	@Override
	@Transactional
	public void saveUser(User user) {
		userDAO.saveUser(user);
	}
	@Override
	@Transactional
	public User getUserByMobileNo(String mobile) {
		return userDAO.getUserByMobileNo(mobile);
	}
	@Override
	@Transactional
	public User getUserByUserName(String userName) {
		return userDAO.getUserByUserName(userName);
	}
	@Override
	@Transactional
	public List<Person> getPersonsList(String userName) {
		return userDAO.getPersonsList(userName);
	}
	

}
