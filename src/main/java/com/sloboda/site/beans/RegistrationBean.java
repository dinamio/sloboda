package com.sloboda.site.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.SecureRandom;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.commons.io.FileUtils;
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
			insertCopyOfFile();
		}
		userService.insertUser(user);
		loginBean.setMessage("Регистрация успешна!");
		return "success";
	}
	
	private static void copyFileUsingFileStreams(InputStream source, File dest)
			throws IOException {
		OutputStream output = null;
		try {
			output = new FileOutputStream(dest);
			byte[] buf = new byte[1024];
			int bytesRead;
			while ((bytesRead = source.read(buf)) > 0) {
				output.write(buf, 0, bytesRead);
			}
		} finally {
			output.close();
		}
	}

	private void insertCopyOfFile() {
		String newFileName=generateFileName();
		File des = new File("downloads/" + newFileName + file.getFileName().substring(file.getFileName().lastIndexOf('.')));
		des.getParentFile().mkdirs();
		try {
			des.createNewFile();
			copyFileUsingFileStreams(file.getInputstream(), des);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Photo photo = new Photo();
		photo.setPath(des.getPath());
		user.setAvatar(photo);
	}

	private String generateFileName() {
		 SecureRandom random = new SecureRandom();
	    return new BigInteger(130, random).toString(32);
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
