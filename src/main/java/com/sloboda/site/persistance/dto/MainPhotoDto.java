package com.sloboda.site.persistance.dto;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "main_photos")
public class MainPhotoDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1134532893674657064L;

	@Id
	@ManyToOne
	@JoinColumn(name = "photo_id")
	private PhotoDto photo;
	
	@Column(name = "description")
	private String description;

	public PhotoDto getPhoto() {
		return photo;
	}

	public void setPhoto(PhotoDto photo) {
		this.photo = photo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
