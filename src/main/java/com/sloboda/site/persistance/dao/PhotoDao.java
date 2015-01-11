package com.sloboda.site.persistance.dao;

import java.util.List;

import com.sloboda.site.persistance.dto.MainPhotoDto;

public interface PhotoDao {

	List<MainPhotoDto> getAllPhotos();
}
