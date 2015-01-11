package com.sloboda.site.beans;

import java.util.ResourceBundle;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;





import org.springframework.stereotype.Component;

import com.sloboda.site.entity.User;
import com.sloboda.site.persistance.dto.UserDto;

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
