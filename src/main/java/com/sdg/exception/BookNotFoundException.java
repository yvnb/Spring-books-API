package com.sdg.exception;


@SuppressWarnings("serial")
public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(Long bookId) {
        super(String.format("Book not found for Id: %s" , bookId));
    }
}