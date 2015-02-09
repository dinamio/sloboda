package com.sloboda.site.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sloboda.site.entity.Article;
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
	public List<Article> getNewsForHome() {
		List<NewsDto> dtos = newsDao.getNewsForHome();
		List<Article> news = new ArrayList<Article>();
		newsTranslator.fromDtoList(dtos, news);
		return news;
	}
	
	@Override
	public List<Article> getAllNews() {
		List<NewsDto> dtos = newsDao.getAllNews();
		List<Article> news = new ArrayList<Article>();
		newsTranslator.fromDtoList(dtos, news);
		return news;
	}
	
	
	
	
}
