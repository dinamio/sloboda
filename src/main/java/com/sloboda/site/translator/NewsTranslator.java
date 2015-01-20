package com.sloboda.site.translator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sloboda.site.entity.Comment;
import com.sloboda.site.entity.News;
import com.sloboda.site.entity.Photo;
import com.sloboda.site.entity.User;
import com.sloboda.site.persistance.dto.NewsDto;
import com.sloboda.site.persistance.dto.PhotoDto;
import com.sloboda.site.persistance.dto.UserDto;

@Component
public class NewsTranslator {
	
	@Autowired
	private PhotoTranslator photoTranslator;
	
	@Autowired
	private CommentTranslator commentTranslator;
	
	@Autowired
	private UserTranslator userTranslator;
	
	public void fromDtoList (List<NewsDto> dtos, List<News> news) {
		for(NewsDto dto : dtos) {
			News entity = new News();
			fromDto(dto,entity);
			news.add(entity);
		}
	}
	
	public void fromDto (NewsDto dto, News entity) {
		entity.setId(dto.getId());
		
		entity.setText(dto.getText().replaceAll("(\r\n|\n)", "<br />"));
		entity.setTitle(dto.getTitle());
		entity.setCreatedDate(dto.getCreatedDate());
		
		List<Comment> comments = new ArrayList<Comment>();
		commentTranslator.fromDtoList(dto.getComments(),comments);
		entity.setComments(comments);
		
		Photo photo = new Photo();
		photoTranslator.fromDto(dto.getPhoto(), photo);
		entity.setPhoto(photo);
		
		User author = new User();
		userTranslator.fromDto(dto.getAuthor(), author);
		entity.setAuthor(author);
	}
	public void toDto(News entity, NewsDto dto)
	{
		dto.setId(entity.getId());
		
		UserDto userDto = new UserDto();
		userTranslator.toDto(entity.getAuthor(), userDto);
		dto.setAuthor(userDto);
		
		PhotoDto photoDto = new PhotoDto();
		photoTranslator.toDto(entity.getPhoto(), photoDto);
		dto.setPhoto(photoDto);
		
		dto.setText(entity.getText());
		dto.setTitle(entity.getTitle());
		dto.setCreatedDate(entity.getCreatedDate());
	}
}
