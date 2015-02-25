package com.sloboda.site.beans;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sloboda.site.entity.Photo;
import com.sloboda.site.entity.User;
import com.sloboda.site.persistance.dao.UserDao;
import com.sloboda.site.service.PhotoService;
import com.sloboda.site.service.UserService;

@ManagedBean
@Component
@Scope("request")
public class RegistrationBean {

	private UploadedFile file;

	private User user;

	@Autowired
	private UserService userService;

	@Autowired
	private UserDao userDao;

	@Autowired
	private PhotoService photoService;

	@Autowired
	private LoginBean loginBean;

	@PostConstruct
	public void init() {
		user = new User();
	}

	public String submit() {
		if (userDao.isUserExist(user.getLogin())) {
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Пользователь с таким логином уже существует", ""));
			 return "";
		}
		if (file != null) {
		  String photoPath = photoService.insertPhotoAndReturnPath(file);
			Photo photo = new Photo();
	    photo.setPath(photoPath);
	    user.setAvatar(photo);
		}
		userService.insertUser(user);
		loginBean.setMessage("Регистрация успешна!");
		return "success";
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
