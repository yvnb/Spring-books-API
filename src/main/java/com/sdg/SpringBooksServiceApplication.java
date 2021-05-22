package com.sdg;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sdg.domain.BookDiscount;
import com.sdg.domain.BookType;
import com.sdg.repository.BookDiscountRepository;

@SpringBootApplication
public class SpringBooksServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBooksServiceApplication.class, args);
	}
	
	@Bean
    ApplicationRunner init(BookDiscountRepository bookDiscountRepository) {
        return (ApplicationArguments args) ->  dataSetup(bookDiscountRepository);
    } 

    public void dataSetup(BookDiscountRepository bookDiscountRepository){
    	bookDiscountRepository.save(new BookDiscount(1L, BookType.NONFICTION, 5.0, "NONFICTION"));
    	bookDiscountRepository.save(new BookDiscount(2L, BookType.COMICAL, 7.0, "COMICAL"));
    	bookDiscountRepository.save(new BookDiscount(3L, BookType.FICTION, 8.0, "FICTION"));
    	bookDiscountRepository.save(new BookDiscount(4L, BookType.CLASSIC, 9.0, "CLASSIC"));
    	bookDiscountRepository.save(new BookDiscount(5L, BookType.MYSTERY, 6.0, "MYSTERY"));
    	bookDiscountRepository.save(new BookDiscount(6L, BookType.HISTORY, 8.0, "HISTORY"));  	
    }

}
