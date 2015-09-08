package com.noobcoder.service;

import java.util.List;

import com.noobcoder.model.User;

public interface UserService {
	public void create(User user);
	public List<User> getAll();
	public void delete(User user);
	public void suspendOrEnable(String username,int enabled);
}
