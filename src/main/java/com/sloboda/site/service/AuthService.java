package com.sloboda.site.service;

import com.sloboda.site.entity.User;

public interface AuthService {
	
	public User getAuthenticatedUser(String login, String password);
}
