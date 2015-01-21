package com.sloboda.site.translator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sloboda.site.entity.Photo;
import com.sloboda.site.entity.User;
import com.sloboda.site.persistance.dto.PhotoDto;
import com.sloboda.site.persistance.dto.UserDto;

@Component
public class UserTranslator {
	
	@Autowired
	private PhotoTranslator photoTranslator;
	
	public void fromDto(UserDto dto, User user) {
		user.setId(dto.getId());
		user.setLogin(dto.getLogin());
		user.setPassword(dto.getPassword());
		
		user.setEmail(dto.getEmail());
		user.setName(dto.getName());
		user.setSurname(dto.getSurname());
		if (dto.getAvatar() != null) {
			Photo avatar = new Photo();
			photoTranslator.fromDto(dto.getAvatar(), avatar);
			user.setAvatar(avatar);
		}
	}
	public void toDto(User user, UserDto dto)
	{
		dto.setId(user.getId());
		dto.setLogin(user.getLogin());
		dto.setPassword(user.getPassword());
		
		dto.setEmail(user.getEmail());
		dto.setName(user.getName());
		dto.setSurname(user.getSurname());
		if (user.getAvatar() != null) {
			PhotoDto avatar = new PhotoDto();
			photoTranslator.toDto(user.getAvatar(),avatar);
			dto.setAvatar(avatar);
		}
	}
}
