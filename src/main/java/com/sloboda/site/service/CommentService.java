package com.sloboda.site.service;

import java.util.List;

import com.sloboda.site.entity.Comment;

public interface CommentService {
	
	void save(Comment entity);
	
	List<Comment> getComments(Long articleId);
	
}
