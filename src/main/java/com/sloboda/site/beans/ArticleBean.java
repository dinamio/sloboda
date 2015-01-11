package com.sloboda.site.beans;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sloboda.site.entity.News;

@ManagedBean
@Component
@Scope("request")
public class ArticleBean {
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleBean.class);
	
	private News currentArticle;
	
	public String action() {
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String action = params.get("param");
		logger.info("Action:" + action);
		return "article";
	}

	public News getCurrentArticle() {
		return currentArticle;
	}

	public void setCurrentArticle(News currentArticle) {
		this.currentArticle = currentArticle;
	} 
}
