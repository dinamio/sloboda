package com.sloboda.site.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sloboda.site.entity.News;
import com.sloboda.site.persistance.dao.NewsDao;
import com.sloboda.site.persistance.dto.NewsDto;
import com.sloboda.site.translator.NewsTranslator;

@Service
public class NewsServiceImpl implements NewsService {
	
	@Autowired
	private NewsDao newsDao;
	
	@Autowired
	private NewsTranslator newsTranslator;
	
	@Override
	public List<News> getNewsForHome() {
		List<NewsDto> dtos = newsDao.getNewsForHome();
		List<News> news = new ArrayList<News>();
		newsTranslator.fromDtoList(dtos, news);
		return news;
	}
	
	@Override
	public List<News> getAllNews() {
		List<NewsDto> dtos = newsDao.getAllNews();
		List<News> news = new ArrayList<News>();
		newsTranslator.fromDtoList(dtos, news);
		return news;
	}
	
	
	
	
}
