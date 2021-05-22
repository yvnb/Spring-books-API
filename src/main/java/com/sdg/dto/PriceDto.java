package com.sdg.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceDto {

	private String promoCode;
	private boolean isPromoValid;
	private Double totalPrice;
	private Double discountedPrice;
	private Double discount;
	private Double netPrice;
	
}
