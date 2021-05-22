package com.sdg.exception.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import com.sdg.exception.BookNotFoundException;

@ControllerAdvice
public class BookNotFoundAdvice {
	
	  @ResponseBody
	  @ExceptionHandler(BookNotFoundException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  String bookNotFoundHandler(BookNotFoundException ex) {
	    return ex.getMessage();
	  }
}
