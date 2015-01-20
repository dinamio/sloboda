package com.sloboda.site.persistance.dao;

import java.util.List;

import com.sloboda.site.persistance.dto.CommentDto;

public interface CommentDao {
	
	void save(CommentDto dto);
	
	List<CommentDto> getComments(Long articleId);
	
}
