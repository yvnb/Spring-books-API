package com.sdg.service.impl;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import com.sdg.domain.BookDiscount;
import com.sdg.domain.BookType;
import com.sdg.dto.LineItemDto;
import com.sdg.dto.OrderDto;
import com.sdg.dto.PriceDto;
import com.sdg.repository.BookDiscountRepository;


@ExtendWith(MockitoExtension.class)
public class CheckoutServiceImplTest {
	
	@InjectMocks
	CheckoutServiceImpl checkoutServiceImpl;
	@Mock
	BookDiscountServiceImpl bookDiscountServiceImpl;
	@Mock
	BookDiscountRepository bookDiscountRepository;
	
	public static BookDiscount bookDiscount;
	
	public static OrderDto orderDto;
	
	@BeforeEach
	void setup() {
		bookDiscount = new BookDiscount(1L, BookType.NONFICTION, 5.0, "NONFICTION");
		List<LineItemDto> lineItems = List.of(new LineItemDto("Spring in Action", 1, 230.0, 1L, BookType.NONFICTION), new LineItemDto("The Adventures of Tom Sayer", 2, 135.0, 2L, BookType.FICTION));
		String promoCode = "NonFiction";
		orderDto = new OrderDto(lineItems, promoCode);
	}

	@Test
	void test_totalBasketPrice() {
		Mockito.when(bookDiscountServiceImpl.findBookDiscountByPromoCode(Mockito.anyString())).thenReturn(Optional.of(bookDiscount));
		PriceDto price = checkoutServiceImpl.getTotalBasketPrice(orderDto);
		Assertions.assertEquals(price.getDiscountedPrice(), 11.5);			
	}
	
	
}
