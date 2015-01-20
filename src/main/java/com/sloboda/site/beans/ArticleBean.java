package com.sloboda.site.beans;

import java.util.Date;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sloboda.site.entity.Comment;
import com.sloboda.site.entity.News;
import com.sloboda.site.service.CommentService;

@ManagedBean
@Component
@Scope("session")
public class ArticleBean {
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleBean.class);
	
	private News currentArticle;
	
	private Comment comment;
	
	@Autowired
	private UserBean userBean;
	
	@Autowired
	private CommentService commentService;
	
	@PostConstruct
	public void init() {
		comment=new Comment();
	}
	
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
	
	public void addComment()
	{
		comment.setAuthor(userBean.getUser());
		comment.setArticle(currentArticle);
		Date createdDate = new Date();
		comment.setCreatedDate(createdDate);
		commentService.save(comment);
		updateComments();
		comment = new Comment();
	}
	
	public Comment getComment()
	{
		return comment;
	}
	public void setComment(Comment comment)
	{
		this.comment = comment;
	}
	public void updateComments()
	{
		currentArticle.setComments(commentService.getComments(currentArticle.getId()));
	}
	
}
