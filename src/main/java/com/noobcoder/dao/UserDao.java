package com.noobcoder.dao;

import java.util.List;

import com.noobcoder.model.User;

public interface UserDao {
	public void createUser(User user);
	public List<User> getAll();
	public void delete(User user);
	public void suspendOrEnable(String username, int enabled);
}
