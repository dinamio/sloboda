package com.sloboda.site.service;

import java.util.List;

import com.sloboda.site.entity.MainPhoto;
import com.sloboda.site.entity.Photo;

public interface PhotoService {

	List<MainPhoto> getPhotosForMain();
	
	void insertPhoto(Photo photo);
}
