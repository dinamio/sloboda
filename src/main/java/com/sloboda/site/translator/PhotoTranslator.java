package com.sloboda.site.translator;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sloboda.site.entity.Photo;
import com.sloboda.site.persistance.dto.PhotoDto;
import com.sloboda.site.persistance.dto.PhotoNewsDto;

@Component
public class PhotoTranslator{
	
	public void fromDtoList(List<PhotoDto> dtos, List<Photo> entity) {
		for(PhotoDto dto : dtos) {
			Photo photo = new Photo();
			fromDto(dto,photo);
			entity.add(photo);
		}
	}
	
	public void fromDto(PhotoDto dto, Photo entity){
		entity.setDescription(dto.getDescription());
		entity.setPath(dto.getPath());
		entity.setPosition(dto.getPosition());
	}
	
	public void fromPhotoNewsDto(PhotoNewsDto dto, Photo entity) {
		entity.setPath(dto.getPath());
	}
}
