package com.sdg.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdg.domain.Book;
import com.sdg.exception.BookNotFoundException;
import com.sdg.service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController {

	private static final Logger logger = LogManager.getLogger(BookController.class);
	
	@Autowired
	private BookService bookService;

	@GetMapping
	public List<Book> getBooks() {
		List<Book> books = bookService.getBooks();
		return books;
	}

	@GetMapping("/{bookId}")
	public Book getBook(@PathVariable(name = "bookId") Long bookId) {
		logger.info("Fetching the book for the id : {}", () -> bookId);
		return bookService.getBookById(bookId).orElseThrow(() -> new BookNotFoundException(bookId));
	}

	@PostMapping
	public Book saveBook(@RequestBody Book book) {
		logger.info("saving the book : {}", () -> book);
		return bookService.saveBook(book);		
	} 

/*	@PostMapping
	public List<Book> saveBooks(@RequestBody List<Book> books) {
		return bookService.saveBooks(books);		
	} */
	
	@DeleteMapping("/{bookId}")
	public void deleteBook(@PathVariable(name = "bookId") Long bookId) {
		bookService.deleteBook(bookId);
		logger.info("Book deleted successfully for id : {}", () -> bookId);
	}

	@PutMapping("/{bookId}")
	public Book updateBook(@RequestBody Book newBook, @PathVariable(name = "bookId") Long bookId) {
		Optional<Book> book = bookService.getBookById(bookId);
		if (book.isPresent()) {
			newBook.setId(bookId);
			return bookService.updateBook(newBook);
		}else {
			logger.info("Book not found for id : {}", () -> bookId);
			throw new BookNotFoundException(bookId);
		}

	}

}
