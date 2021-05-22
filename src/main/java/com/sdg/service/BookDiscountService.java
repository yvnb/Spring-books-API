package com.sdg.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.sdg.domain.BookDiscount;
import com.sdg.domain.BookType;

public interface BookDiscountService {

	public Optional<BookDiscount> findBookDiscountByType(String bookType);
	public List<BookDiscount> findAllBookDiscountByType(Set<BookType> bookTypes);
	public Optional<BookDiscount> findBookDiscountByPromoCode(String promoCode);
	
}
