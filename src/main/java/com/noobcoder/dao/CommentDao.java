package com.noobcoder.dao;

import java.util.List;

import com.noobcoder.model.Comment;

public interface CommentDao {
	public List<Comment> getComments(int id);
}
