package com.sloboda.site.service;

import java.util.List;

import org.primefaces.model.UploadedFile;

import com.sloboda.site.entity.MainPhoto;
import com.sloboda.site.entity.Photo;

public interface PhotoService {

	List<MainPhoto> getPhotosForMain();

	String insertPhotoAndReturnPath(UploadedFile file);

	void insertPhoto(Photo photo);
}
