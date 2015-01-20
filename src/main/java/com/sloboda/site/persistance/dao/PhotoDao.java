package com.sloboda.site.persistance.dao;

import java.util.List;

import com.sloboda.site.persistance.dto.MainPhotoDto;
import com.sloboda.site.persistance.dto.PhotoDto;

public interface PhotoDao {

	List<MainPhotoDto> getAllPhotos();
	
	void savePhoto(PhotoDto photo);
}
