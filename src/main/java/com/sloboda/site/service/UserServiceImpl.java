package com.sloboda.site.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sloboda.site.entity.User;
import com.sloboda.site.persistance.dao.UserDao;
import com.sloboda.site.persistance.dto.UserDto;
import com.sloboda.site.translator.UserTranslator;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserTranslator userTranslator;
	
	@Autowired
	private UserDao userDao;

	@Override
	public void insertUser(User user) {
		UserDto dto = new UserDto();
		userTranslator.toDto(user, dto);
		userDao.save(dto);
	}
	
	@Override
	public User getAuthenticatedUser(String login, String password) {
		UserDto dto = userDao.getAuthData(login, password);
		if (dto==null) return null;
		User user = new User();
		userTranslator.fromDto(dto, user);
		return user;
	}


}
