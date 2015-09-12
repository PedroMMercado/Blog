package com.noobcoder.service;

import java.util.List;

import com.noobcoder.model.Blog;

public interface BlogService {
	public void create(Blog blog);
	public void update(Blog blog);
	public void delete(Blog blog);
	public String getBlogName(String username);
	public List<Blog> getAllUser(String blogname); 
	public List<Blog> getAll(int pageNumber);
	public Blog getByID(int id);

}
