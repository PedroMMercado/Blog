package com.noobcoder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noobcoder.dao.CommentDao;
import com.noobcoder.model.Comment;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentDao commentDao;

	public List<Comment> getComments(int id) {
		return commentDao.getComments(id);
	}

}
