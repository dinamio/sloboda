package com.sloboda.site.beans;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sloboda.site.entity.User;
import com.sloboda.site.service.UserService;

@ManagedBean
@Component
@Scope("request")
public class LoginBean {
	
	private String login;
	
	private String password;
	
	private String message;
	
	@Autowired
	private UserBean userBean;
	
	@Autowired 
	private UserService userService;
	
	public String performLogin() {
		User user = userService.getAuthenticatedUser(login, password);
		message=null;
		if (user==null) {
			login=null;
			password=null;
			setMessage("Неправильный логин/пароль");
			return "failure";
		}
		userBean.setUser(user);
		return "success";
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
