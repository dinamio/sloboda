package com.sloboda.site.translator;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sloboda.site.entity.Comment;
import com.sloboda.site.entity.User;
import com.sloboda.site.persistance.dto.CommentDto;
import com.sloboda.site.persistance.dto.NewsDto;
import com.sloboda.site.persistance.dto.UserDto;

@Component
public class CommentTranslator {
	
	@Autowired
	private UserTranslator userTranslator;
	
	@Autowired
	private NewsTranslator articleTranslator;

	public void fromDtoList(List<CommentDto> dtos, List<Comment> entity) {
		for (CommentDto dto : dtos) {
			Comment comment = new Comment();
			fromDto(dto, comment);
			entity.add(comment);
		}
	}
	
	public void fromDto(CommentDto dto, Comment entity) {
		User author = new User();
		userTranslator.fromDto(dto.getUser(),author);
		entity.setAuthor(author);
		entity.setCreatedDate(dto.getCreatedDate());
		entity.setText(dto.getText());
	}
	
	public void toDto(Comment entity,CommentDto dto)
	{
		UserDto author = new UserDto();
		userTranslator.toDto(entity.getAuthor(),author);
		dto.setUser(author);
		
		NewsDto article = new NewsDto();
		articleTranslator.toDto(entity.getArticle(),article);
		dto.setArticle(article);
		
		dto.setText(entity.getText());
		dto.setCreatedDate(entity.getCreatedDate());
	}	
}
