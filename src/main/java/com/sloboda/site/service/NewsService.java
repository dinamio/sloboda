package com.sloboda.site.service;

import java.util.List;

import com.sloboda.site.entity.Article;

public interface NewsService {

	List<Article> getNewsForHome();

	List<Article> getAllNews();

}
