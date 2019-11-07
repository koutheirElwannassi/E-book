/**
 * 
 */
package com.koutheir.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.koutheir.spring.model.Book;
import com.koutheir.spring.service.BookService;

/**
 * @author koutheir
 * 
 */
@CrossOrigin("*")
@RestController
public class BookController {

   @Autowired
   private BookService bookService;

   /*---Add new book---*/
   @CrossOrigin
   @PostMapping("/book")
   public ResponseEntity<?> save(@RequestBody Book book) {
	  System.out.println("the json value of book is :::::: "+book);
      long id = bookService.save(book);
      return ResponseEntity.ok().body("New Book has been saved with ID:" + id);
   }
   
   /*---Get a book by id---*/
   @CrossOrigin
   @GetMapping("/book/{id}")
   public ResponseEntity<Book> get(@PathVariable("id") long id) {
      Book book = bookService.get(id);
      return ResponseEntity.ok().body(book);
   }

   /*---get all books---*/
   @CrossOrigin
   @GetMapping("/book")
   public ResponseEntity<List<Book>> list() {
      List<Book> books = bookService.list();
      return ResponseEntity.ok().body(books);
   }

   /*---Update a book by id---*/
   @CrossOrigin
   @PutMapping("/book/{id}")
   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Book book) {
      bookService.update(id, book);
      return ResponseEntity.ok().body("Book has been updated successfully.");
   }

   /*---Delete a book by id---*/
   @CrossOrigin
   @DeleteMapping("/book/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") long id) {
      bookService.delete(id);
      return ResponseEntity.ok().body("Book has been deleted successfully.");
   }
}
