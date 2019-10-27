/**
 * 
 */
package com.koutheir.spring.service;

import java.util.List;

import com.koutheir.spring.model.Book;

/**
 * @author koutheir
 * 
 */
public interface BookService {
	
	long save(Book book);
	 
	Book get(long id);
 
	List<Book> list();
 
	void update(long id, Book book);
 
	void delete(long id);


}
