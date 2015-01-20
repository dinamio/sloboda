package com.sloboda.site.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sloboda.site.entity.MainPhoto;
import com.sloboda.site.entity.Photo;
import com.sloboda.site.persistance.dao.PhotoDao;
import com.sloboda.site.persistance.dto.MainPhotoDto;
import com.sloboda.site.persistance.dto.PhotoDto;
import com.sloboda.site.translator.PhotoTranslator;

@Service
public class PhotoServiceImpl implements PhotoService {

	@Autowired
	private PhotoTranslator photoTranslator;
	
	@Autowired
	private PhotoDao photoDao;
	
	@Override
	public List<MainPhoto> getPhotosForMain() {
		List<MainPhotoDto> photoDtos = photoDao.getAllPhotos();
		List<MainPhoto> result = new ArrayList<MainPhoto>();
		photoTranslator.fromDtoList(photoDtos, result);
		return result;
	}

	@Override
	public void insertPhoto(Photo photo) {
		PhotoDto dto = new PhotoDto();
		photoTranslator.toDto(photo, dto);
		photoDao.savePhoto(dto);
	}

}
