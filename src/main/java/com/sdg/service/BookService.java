package com.sdg.service;

import java.util.List;
import java.util.Optional;

import com.sdg.domain.Book;

public interface BookService {
	
	 public List<Book> getBooks();
	  
	 public Optional<Book> getBookById(Long bookId);
	 
	 public List<Book> getBookByIsbn(String isbn);
	 
	 public List<Book> getBookByAuthor(String author);
	 
	 public List<Book> getBookByName(String bookName);
	  
	 public Book saveBook(Book book);
	 
	 public List<Book> saveBooks(List<Book> books);
	 
	 public void deleteBook(Long bookId);
	  
	 public Book updateBook(Book book);
}
