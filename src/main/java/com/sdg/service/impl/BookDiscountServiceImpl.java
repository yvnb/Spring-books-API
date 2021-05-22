package com.sdg.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdg.domain.BookDiscount;
import com.sdg.domain.BookType;
import com.sdg.repository.BookDiscountRepository;
import com.sdg.service.BookDiscountService;

@Service
public class BookDiscountServiceImpl implements BookDiscountService{
	
	@Autowired
	BookDiscountRepository bookDiscountRepository;

	@Override
	public Optional<BookDiscount> findBookDiscountByType(String bookType) {
		return bookDiscountRepository.findByBookType(BookType.valueOf(bookType));
	}

	@Override
	public List<BookDiscount> findAllBookDiscountByType(Set<BookType> bookTypes) {
		return bookDiscountRepository.findAllByBookTypeIn(bookTypes);
	}

	@Override
	public Optional<BookDiscount> findBookDiscountByPromoCode(String promoCode) {
		return bookDiscountRepository.findByPromoCode(promoCode);
	}
	
	
}
