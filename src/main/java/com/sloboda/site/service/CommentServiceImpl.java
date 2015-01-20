package com.sloboda.site.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sloboda.site.entity.Comment;
import com.sloboda.site.persistance.dao.CommentDao;
import com.sloboda.site.persistance.dto.CommentDto;
import com.sloboda.site.translator.CommentTranslator;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentDao commentDao;
	
	@Autowired
	private CommentTranslator commentTranslator;
	
	@Override
	public void save(Comment entity)
	{
		CommentDto dto = new CommentDto();
		commentTranslator.toDto(entity, dto);
		commentDao.save(dto);
	}

	@Override
	public List<Comment> getComments(Long articleId) {
		List<CommentDto> dtos = commentDao.getComments(articleId);
		List<Comment> comments = new ArrayList<Comment>();
		commentTranslator.fromDtoList(dtos, comments);
		return comments;
	}
}
