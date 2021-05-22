package com.sdg.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdg.domain.BookDiscount;
import com.sdg.domain.BookType;
import com.sdg.dto.LineItemDto;
import com.sdg.dto.OrderDto;
import com.sdg.dto.PriceDto;
import com.sdg.service.BookDiscountService;
import com.sdg.service.CheckoutService;

@Service
public class CheckoutServiceImpl implements CheckoutService {
	
	private static final Logger logger = LogManager.getLogger(CheckoutServiceImpl.class);
	
	@Autowired
	BookDiscountService bookDiscountService;

	@Override
	public PriceDto getTotalBasketPrice(OrderDto orderDto) {
		List<LineItemDto> lineItems = orderDto.getLineItemDtoList();
		String promoCode = orderDto.getPromoCode();
		logger.info("Fetching the book discount for the promoCode : {}", () -> promoCode);
		PriceDto priceDto = new PriceDto();
		double perDiscount = 0;
		double totalAmt = 0;
		double discountAmt = 0;
		BookType promoType = null;
		if(!promoCode.isEmpty()) {
			//Get the discount percentage for the book type
			Optional<BookDiscount> bookDiscount = bookDiscountService.findBookDiscountByPromoCode(promoCode);
			if (bookDiscount.isPresent()) {
				perDiscount = bookDiscount.get().getDiscount();
				promoType = bookDiscount.get().getBookType();
			}
		}		
		for (LineItemDto lineItem : lineItems) {
			totalAmt += lineItem.getPrice() * lineItem.getQuantity();
			if(lineItem.getBookType() !=null && lineItem.getBookType().equals(promoType)) {
				discountAmt += (lineItem.getPrice() * lineItem.getQuantity() * perDiscount)/100;
			}
		}
		priceDto.setDiscount(perDiscount);
		priceDto.setDiscountedPrice(discountAmt);
		priceDto.setPromoCode(promoCode);
		priceDto.setTotalPrice(totalAmt);
		priceDto.setNetPrice(totalAmt - discountAmt);
		if(discountAmt > 0) {
			priceDto.setPromoValid(true);
		}else {
			priceDto.setPromoValid(false);
		}	
		
		return priceDto;
	}

}
