package com.sloboda.site.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sloboda.site.persistance.HibernateUtil;
import com.sloboda.site.persistance.dto.PhotoDto;

@Repository
public class PhotoDaoImpl implements PhotoDao {

	@Override
	public List<PhotoDto> getAllPhotos() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query q = session.createQuery("select p from " + PhotoDto.class.getName() + " p");
		List<PhotoDto> resultList = q.list();
		return resultList;
	}

}
