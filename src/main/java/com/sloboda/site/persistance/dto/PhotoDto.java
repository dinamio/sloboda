package com.sloboda.site.persistance.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "photos")
public class PhotoDto {

	@Id
	@Column(name = "path")
	private String path;

	@Column(name = "description")
	private String description;
	
	@Column(name = "position")
	private Integer position;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

}
