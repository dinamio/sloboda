package com.sloboda.site.persistance.dao;

import com.sloboda.site.persistance.dto.UserDto;

public interface UserDao {
	
	public UserDto getAuthData(String login, String password);

}
