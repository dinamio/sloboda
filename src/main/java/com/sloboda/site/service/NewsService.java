package com.sloboda.site.service;

import java.util.List;

import com.sloboda.site.entity.News;

public interface NewsService {

	List<News> getNewsForHome();

	List<News> getAllNews();

}
