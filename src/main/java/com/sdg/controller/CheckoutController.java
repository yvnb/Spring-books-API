package com.sdg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdg.dto.OrderDto;
import com.sdg.dto.PriceDto;
import com.sdg.service.CheckoutService;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {
	
	@Autowired
	CheckoutService checkoutService;

    @PostMapping
    public PriceDto checkout(@RequestBody OrderDto orderDto) {
    	return checkoutService.getTotalBasketPrice(orderDto);
    }
	
}
