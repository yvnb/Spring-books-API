package com.sdg.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sdg.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findByIsbnContaining(String isbn);
	List<Book> findByAuthorContaining(String author);
	List<Book> findByNameContaining(String name);	
}
