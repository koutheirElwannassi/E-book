/**
 * 
 */
package com.koutheir.spring.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koutheir.spring.model.Book;

/**
 * @author koutheir
 *  
 */
@Repository

public class BookDaoImp implements BookDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(Book book) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(book);
		return book.getId();
	}

	@Override
	public Book get(long id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Book.class, id);
		 
	}

	@Override
	public List<Book> list() {
		// TODO Auto-generated method stub
		  Session session = sessionFactory.getCurrentSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<Book> cq = cb.createQuery(Book.class);
	      Root<Book> root = cq.from(Book.class);
	      cq.select(root);
	      Query<Book> query = session.createQuery(cq);
	      return query.getResultList();
	}

	@Override
	public void update(long id, Book book) {
		// TODO Auto-generated method stub
		  Session session = sessionFactory.getCurrentSession();
	      Book book2 = session.byId(Book.class).load(id);
	      book2.setTitle(book.getTitle());
	      book2.setAuthor(book.getAuthor());
	      session.flush();
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		  Session session = sessionFactory.getCurrentSession();
	      Book book = session.byId(Book.class).load(id);
	      session.delete(book);
		
	}

}
