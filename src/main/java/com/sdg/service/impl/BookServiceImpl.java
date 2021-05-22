package com.sdg.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdg.domain.Book;
import com.sdg.repository.BookRepository;
import com.sdg.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> getBooks() {
		List<Book> books = bookRepository.findAll();
		return books;
	}

	@Override
	public Optional<Book> getBookById(Long bookId) {
		Optional<Book> book = bookRepository.findById(bookId);
		return book;
	}

	@Override
	public List<Book> getBookByIsbn(String isbn) {
		List<Book> books = bookRepository.findByIsbnContaining(isbn);
		return books;
	}

	@Override
	public List<Book> getBookByAuthor(String author) {
		List<Book> books = bookRepository.findByAuthorContaining(author);
		return books;
	}

	@Override
	public List<Book> getBookByName(String bookName) {
		List<Book> books = bookRepository.findByNameContaining(bookName);
		return books;
	}

	@Override
	public Book saveBook(Book book) {
		Book savedBook = bookRepository.save(book);
		return savedBook;
	}
	
	@Override
	public List<Book> saveBooks(List<Book> books) {
		List<Book> savedBooks = bookRepository.saveAll(books);
		return savedBooks;
	}

	@Override
	public void deleteBook(Long bookId) {
		bookRepository.deleteById(bookId);
	}

	@Override
	public Book updateBook(Book book) {
		Book updatedBook = bookRepository.save(book);
		return updatedBook;
	}

}
