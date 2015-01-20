package com.sloboda.site.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sloboda.site.persistance.HibernateUtil;
import com.sloboda.site.persistance.dto.UserDto;

@Repository
public class UserDaoImpl implements UserDao {

	@Override
	public UserDto getAuthData(String login, String password) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query q = session.createQuery("select p from " + UserDto.class.getName() + " p where login='"+login+"' and password ='"+password+"'");
		List<UserDto> resultList = q.list();
		session.close();
		if (resultList.size()==1) return resultList.get(0);
		return null;
	}

	@Override
	public void save(UserDto user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Boolean isUserExist(String login) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query q = session.createQuery("select p from " + UserDto.class.getName() + " p where login='"+login+"'");
		List<UserDto> resultList = q.list();
		session.close();
		if (resultList.size()==1) return true;
		return false;
	}

}
