package com.sloboda.site.persistance.dao;

import com.sloboda.site.persistance.dto.UserDto;

public interface UserDao {
	
	public UserDto getAuthData(String login, String password);
	
	public void save (UserDto user);
	
	public Boolean isUserExist(String login);

}
