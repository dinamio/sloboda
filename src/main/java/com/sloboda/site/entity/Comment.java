package com.sloboda.site.entity;

import java.util.Date;

public class Comment {

		private String text;
		
		private User author;
		
		private Date createdDate;
		
		private News article;

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public User getAuthor() {
			return author;
		}

		public void setAuthor(User author) {
			this.author = author;
		}

		public Date getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}

		public News getArticle() {
			return article;
		}

		public void setArticle(News article) {
			this.article = article;
		}
}
