package com.sloboda.site.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.sloboda.site.persistance.HibernateUtil;
import com.sloboda.site.persistance.dto.NewsDto;
import com.sloboda.site.persistance.dto.PhotoDto;

@Repository
public class NewsDaoImpl implements NewsDao {

	@Override
	public List<NewsDto> getNewsForHome() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query q = session.createQuery("select p from " + NewsDto.class.getName() + " p order by p.createdDate desc");
		q.setFirstResult(0);
		q.setMaxResults(3);
		List<NewsDto> resultList = q.list();
		return resultList;

	}

	@Override
	public List<NewsDto> getAllNews() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query q = session.createQuery("select p from " + NewsDto.class.getName() + " p order by p.createdDate desc");
		List<NewsDto> resultList = q.list();
		return resultList;
	}

}
