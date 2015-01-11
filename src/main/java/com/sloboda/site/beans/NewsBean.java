package com.sloboda.site.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sloboda.site.entity.News;
import com.sloboda.site.service.NewsService;

@ManagedBean
@Component
@Scope("request")
public class NewsBean {
	
	@Autowired
	private NewsService newsService;
	
	public List<News> getNewsForHome() {
		return newsService.getNewsForHome();
	}
	
	public List<News> getAllNews() {
		return newsService.getAllNews();
	}
}
