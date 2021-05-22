package com.sdg.dto;

import com.sdg.domain.BookType;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LineItemDto {
	private String name;
    private int quantity;
    private double price;
    private long bookId;
    private BookType bookType;
}
