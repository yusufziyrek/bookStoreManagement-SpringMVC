package com.yusufziyrek.BookStoreManagement.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookAddDto {

	private String name;
	private String author;
	private double price;

}
