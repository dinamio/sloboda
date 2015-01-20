package com.sloboda.site.persistance.dto;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="comments")
public class CommentDto {
	
	@GeneratedValue
	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="text_comment")
	private String text;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@ManyToOne( cascade = {CascadeType.ALL} )
	@JoinColumn(name = "user_id")
	private UserDto user;
	
	@ManyToOne( cascade = {CascadeType.ALL} )
	@JoinColumn(name = "news_id")
	private NewsDto news;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}
	
	public NewsDto getArticle()
	{
		return news;
	}
	
	public void setArticle(NewsDto news)
	{
		this.news = news;
	}
}