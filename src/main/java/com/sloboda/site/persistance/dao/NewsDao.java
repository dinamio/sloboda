package com.sloboda.site.persistance.dao;

import java.util.List;

import com.sloboda.site.persistance.dto.NewsDto;

public interface NewsDao {
	
	List<NewsDto> getNewsForHome();
	
	List<NewsDto> getAllNews();
	
}
