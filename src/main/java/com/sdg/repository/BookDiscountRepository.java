package com.sdg.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sdg.domain.BookDiscount;
import com.sdg.domain.BookType;

@Repository
public interface BookDiscountRepository extends JpaRepository<BookDiscount, Long> {
	public List<BookDiscount> findAllByBookTypeIn(Set<BookType> bookTypes);
	public Optional<BookDiscount> findByBookType(BookType bookType);
	public Optional<BookDiscount> findByPromoCode(String promoCode);
}
