package com.sloboda.site.translator;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sloboda.site.entity.Comment;
import com.sloboda.site.entity.User;
import com.sloboda.site.persistance.dto.CommentDto;

@Component
public class CommentTranlator {
	
	@Autowired
	private UserTranslator userTranslator;

	public void fromDtoSet(Set<CommentDto> dtos, List<Comment> entity) {
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
	
}
