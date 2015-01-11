package com.sloboda.site.translator;

import org.springframework.stereotype.Component;

import com.sloboda.site.entity.User;
import com.sloboda.site.persistance.dto.UserDto;

@Component
public class UserTranslator {
	
	
	public void fromDto(UserDto dto, User user) {
		user.setLogin(dto.getLogin());
	}
}
