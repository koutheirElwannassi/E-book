/**
 * 
 */
package com.koutheir.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koutheir.spring.dao.BookDao;
import com.koutheir.spring.model.Book;

/**
 * @author koutheir
 * 
 */
@Service
@Transactional(readOnly = true)
public class BookServiceImp implements BookService {
	@Autowired
	private BookDao bookDao;
	
	@Transactional
	@Override
	public long save(Book book) {
		// TODO Auto-generated method stub
		return bookDao.save(book);
	}

	@Override
	public Book get(long id) {
		// TODO Auto-generated method stub
		return bookDao.get(id);	}

	@Override
	public List<Book> list() {
		// TODO Auto-generated method stub
		return bookDao.list();
	}
    @Transactional
	@Override
	public void update(long id, Book book) {
		// TODO Auto-generated method stub
		bookDao.update(id, book);

	}
    @Transactional
	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
    	 bookDao.delete(id);

	}

}
