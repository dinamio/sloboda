package com.sloboda.site.beans;


import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.springframework.stereotype.Component;

import com.sloboda.site.entity.User;

@ManagedBean
@ApplicationScoped
@Component
public class UserBean {
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
