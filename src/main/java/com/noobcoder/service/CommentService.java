package com.noobcoder.service;

import java.util.List;

import com.noobcoder.model.Comment;

public interface CommentService {
	public List<Comment> getComments(int id);
	public void create(Comment comment);
}
