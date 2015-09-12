package com.noobcoder.dao;

import java.util.List;

import com.noobcoder.model.Blog;

public interface BlogDao {
	public void create(Blog blog);
	public void update(Blog blog);
	public void delete(Blog blog);
	public String getBlogName(String username);
	public List<Blog> getAll(int pageNumber);
	public List<Blog> getAllUser(String blogname);
	public Blog getByID(int id);
}