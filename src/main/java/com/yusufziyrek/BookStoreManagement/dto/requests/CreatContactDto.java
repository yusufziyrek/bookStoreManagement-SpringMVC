package com.yusufziyrek.BookStoreManagement.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatContactDto {

	private String userName;
	private String userEmail;
	private String message;

}
