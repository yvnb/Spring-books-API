package com.sdg.service.impl;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sdg.domain.Book;
import com.sdg.domain.BookType;
import com.sdg.repository.BookRepository;

@ExtendWith(MockitoExtension.class)
public class BookServiceImplTest {

	@InjectMocks
	BookServiceImpl bookServiceImpl;
	@Mock
	BookRepository bookRepository;

	public static Book book;

	@BeforeEach
	void setup() {
		book = new Book(1L, "Spring in Action", "Spring 5 Beginner", "Craig Wallis", BookType.NONFICTION, 230.0,
				"9781782808083");
	}

	@Test
	void test_getBook() {
		Mockito.when(bookRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(book));
		Book testBook = bookServiceImpl.getBookById(1L).get();
		Assertions.assertNotNull(testBook);
	}

	@Test
	void test_getEmptyBook() {
		Book testBook = null;
		Mockito.when(bookRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
		Optional<Book> testBookOptional = bookServiceImpl.getBookById(1L);
		if (testBookOptional.isPresent()) {
			testBook = testBookOptional.get();
		}
		Assertions.assertNull(testBook);
	}

	@Test
	void test_createBook() {
		Mockito.when(bookRepository.save(Mockito.any())).thenReturn(book);
		Book testBook = bookServiceImpl.saveBook(book);
		Assertions.assertNotNull(testBook);
	}
	
	@Test
	void test_updateBook() {
		book.setDescription("Description changed");
		Mockito.when(bookRepository.save(Mockito.any())).thenReturn(book);
		Book testBook = bookServiceImpl.updateBook(book);
		Assertions.assertEquals(testBook.getDescription(), "Description changed");
	}

}
