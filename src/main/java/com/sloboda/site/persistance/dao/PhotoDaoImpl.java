package com.sloboda.site.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sloboda.site.persistance.HibernateUtil;
import com.sloboda.site.persistance.dto.MainPhotoDto;
import com.sloboda.site.persistance.dto.PhotoDto;

@Repository
public class PhotoDaoImpl implements PhotoDao {

	@Override
	public List<MainPhotoDto> getAllPhotos() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query q = session.createQuery("select p from " + MainPhotoDto.class.getName() + " p");
		@SuppressWarnings("unchecked")
		List<MainPhotoDto> resultList = (List<MainPhotoDto>)q.list();
		session.close();
		return resultList;
	}

	@Override
	public void savePhoto(PhotoDto photo) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(photo);
		session.getTransaction().commit();
		session.close();
	}

}
