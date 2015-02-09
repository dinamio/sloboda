package com.sloboda.site.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ValueChangeEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

import com.sloboda.site.entity.Article;
import com.sloboda.site.entity.Comment;
import com.sloboda.site.service.NewsService;

@ManagedBean
@Component
@PropertySource("classpath:default.properties")
@Scope("request")
public class NewsBean {
	
	@Autowired
	private NewsService newsService;
	
	@Value("${news.images}")
	private String defaultImages;
	
	private String chosenImage;
	
	private Article articleToAdd;
	
	private String chooser;
	
	@PostConstruct
	public void init() {
		articleToAdd=new Article();
		chooser = "choose";
		chosenImage = getDefaultPhotos().get(0);
	}
	
	public void photoChooseMethod(ValueChangeEvent e){
		chosenImage = e.getNewValue().toString();
	}
	
	public List<Article> getNewsForHome() {
		return newsService.getNewsForHome();
	}
	
	public List<Article> getAllNews() {
		return newsService.getAllNews();
	}
	
	public List<String> getDefaultPhotos() {
		return new ArrayList<String>(Arrays.asList(defaultImages.split(";")));
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	public Article getArticleToAdd() {
		return articleToAdd;
	}

	public void setArticleToAdd(Article articleToAdd) {
		this.articleToAdd = articleToAdd;
	}

	public String getChooser() {
		return chooser;
	}

	public void setChooser(String chooser) {
		this.chooser = chooser;
	}

	public String getChosenImage() {
		return chosenImage;
	}

	public void setChosenImage(String chosenImage) {
		this.chosenImage = chosenImage;
	}
}
