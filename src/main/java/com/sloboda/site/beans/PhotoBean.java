package com.sloboda.site.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sloboda.site.entity.Photo;
import com.sloboda.site.service.PhotoService;

@ManagedBean
@Component
@Scope("request")
public class PhotoBean {
	
	private static final Logger logger = LoggerFactory.getLogger(PhotoBean.class);
	
	@Autowired
	private PhotoService photoService;
	
	public List<Photo> getPhotosGallery() {
		return photoService.getPhotosForMain();
	}

}
