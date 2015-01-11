package com.sloboda.site.persistance.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sloboda.site.persistance.dto.PhotoDto;


public interface PhotoDao {

	List<PhotoDto> getAllPhotos();
}
