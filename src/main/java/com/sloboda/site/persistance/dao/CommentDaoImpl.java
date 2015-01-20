package com.sloboda.site.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.sloboda.site.persistance.HibernateUtil;
import com.sloboda.site.persistance.dto.CommentDto;

@Repository
public class CommentDaoImpl implements CommentDao{

	@Override
	public void save(CommentDto dto) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=null;
		  try {
		    tx = session.beginTransaction();
		    session.merge(dto);    
		    tx.commit();
		  }
		  finally {
		    session.close();
		  }
	}

	@Override
	public List<CommentDto> getComments(Long articleId) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query q = session.createQuery("select p from "+CommentDto.class.getName()+" p where p.news.id = " + articleId + " order by p.createdDate asc");
		List<CommentDto> resultList = q.list();
		return resultList;
	}	
}
