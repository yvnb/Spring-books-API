package com.sdg.service;

import com.sdg.dto.OrderDto;
import com.sdg.dto.PriceDto;

public interface CheckoutService {

	public PriceDto getTotalBasketPrice(OrderDto orderDto);
	
}
