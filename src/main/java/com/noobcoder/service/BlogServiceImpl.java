package com.noobcoder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.noobcoder.dao.BlogDao;
import com.noobcoder.model.Blog;

@Service
public class BlogServiceImpl implements BlogService {
	
	@Autowired
	private BlogDao blogDao;
	
	@Transactional
	public void create(Blog blog) {
		blogDao.create(blog);
	}
	
	// For Homepage
	public List<Blog> getAll(int pageNumber) {
		return blogDao.getAll(pageNumber);
	}
	
	// For users
	public List<Blog> getAllUser(String blogname) {
		return blogDao.getAllUser(blogname);
	}
	
	@Transactional
	public void update(Blog blog) {
		blogDao.update(blog);
		
	}
	public String getBlogName(String username){
		return blogDao.getBlogName(username);
	}

	public List<Blog> getByID(int id) {
		return blogDao.getByID(id);
	}
	@Transactional
	public void delete(Blog blog) {
		blogDao.delete(blog);
		
	}

}
