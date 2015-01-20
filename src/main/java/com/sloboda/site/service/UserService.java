package com.sloboda.site.service;

import com.sloboda.site.entity.User;

public interface UserService {
	
	public void insertUser(User user);
	
	public User getAuthenticatedUser(String login, String password);

}
