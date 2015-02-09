package com.sloboda.site.entity;

import java.util.Date;
import java.util.List;

public class Article {
	
	private Long id;
	
	private Photo photo;
	
	private String title;
	
	private String text;
	
	private Date createdDate;
	
	private User author;
	
	private List<Comment> comments;

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public String getShortText() {
		if(text.length()<200) return text;
		return text.substring(0, 200)+"...";
	}
	
	public String getLongText() {
		if(text.length()<500) return text;
		return text.substring(0, 500)+"...";
	}

	public List<Comment> getComments() {
		return comments;
	}
	
	public Integer getCommentsSize() {
		return comments.size();
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public String getDateForNews() {
		String months[] = {"Января","Февраля","Марта","Апреля","Мая","Июня","Июля","Августа","Сентября","Октября","Ноября","Декабря"};
		StringBuilder builder = new StringBuilder();
		builder.append("- ");
		if (createdDate.getDate()<10) builder.append('0');
		builder.append(createdDate.getDate())
		.append(" -<br/>").append(months[createdDate.getMonth()])
		.append("<br/>").append(createdDate.getYear()+1900); 
		return builder.toString();
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	
}
