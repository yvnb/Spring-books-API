package com.sdg.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDto {

	private List<LineItemDto> LineItemDtoList;
	private String promoCode;
	
}
