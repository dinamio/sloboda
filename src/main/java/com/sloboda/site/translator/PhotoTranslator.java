package com.sloboda.site.translator;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sloboda.site.entity.MainPhoto;
import com.sloboda.site.entity.Photo;
import com.sloboda.site.persistance.dto.PhotoDto;
import com.sloboda.site.persistance.dto.MainPhotoDto;

@Component
public class PhotoTranslator{
	
	public void fromDtoList(List<MainPhotoDto> dtos, List<MainPhoto> entity) {
		for(MainPhotoDto dto : dtos) {
			MainPhoto photo = new MainPhoto();
			fromDto(dto,photo);
			entity.add(photo);
		}
	}
	
	public void fromDto(PhotoDto dto, Photo entity){
		entity.setPath(dto.getPath());
	}
	
	public void fromDto(MainPhotoDto dto, MainPhoto entity) {
		Photo photo = new Photo();
		fromDto(dto.getPhoto(),photo);
		entity.setPhoto(photo);
		entity.setDescription(dto.getDescription());
	}
}
