package com.noobcoder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.noobcoder.dao.UserDao;
import com.noobcoder.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	public void setUserDao(UserDao userDao){
		this.userDao = userDao;
	}
	@Transactional
	public void create(User user) {
		userDao.createUser(user);
	}
	public List<User> getAll() {
		return userDao.getAll();
	}
	@Transactional
	public void delete(User user) {
		userDao.delete(user);
		
	}
	@Transactional
	public void suspendOrEnable(String username,int enabled) {
		userDao.suspendOrEnable(username,enabled);
		
	}
}

