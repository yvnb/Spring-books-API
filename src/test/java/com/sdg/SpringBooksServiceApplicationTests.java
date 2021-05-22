package com.sdg;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.sdg.controller.BookController;
import com.sdg.controller.CheckoutController;


@SpringBootTest
class SpringBooksServiceApplicationTests {

	@Autowired
    BookController bookController;
	
	@Autowired
	CheckoutController checkoutController;
	
	@Test
	void contextLoads() {
		Assertions.assertThat(bookController).isNotNull();
		Assertions.assertThat(checkoutController).isNotNull();
	}

}
