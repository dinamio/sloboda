package com.sloboda.site.persistance.dto;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "news")
public class NewsDto {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "text_news")
	private String text;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@ManyToOne
	@JoinColumn(name = "photo_id")
	private PhotoNewsDto photoNews;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	private UserDto author;
	
	@OneToMany(mappedBy="news")
	private Set<CommentDto> comments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public PhotoNewsDto getPhotoNews() {
		return photoNews;
	}

	public void setPhotoNews(PhotoNewsDto photoNews) {
		this.photoNews = photoNews;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Set<CommentDto> getComments() {
		return comments;
	}

	public void setComments(Set<CommentDto> comments) {
		this.comments = comments;
	}

	public UserDto getAuthor() {
		return author;
	}

	public void setAuthor(UserDto author) {
		this.author = author;
	}
}
