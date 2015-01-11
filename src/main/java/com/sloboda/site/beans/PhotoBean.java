package com.sloboda.site.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sloboda.site.entity.MainPhoto;
import com.sloboda.site.service.PhotoService;

@ManagedBean
@Component
@Scope("request")
public class PhotoBean {
	
	@Autowired
	private PhotoService photoService;
	
	public List<MainPhoto> getPhotosGallery() {
		return photoService.getPhotosForMain();
	}

}
