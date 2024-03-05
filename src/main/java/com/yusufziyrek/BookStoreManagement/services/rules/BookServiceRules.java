package com.yusufziyrek.BookStoreManagement.services.rules;

import org.springframework.stereotype.Service;

import com.yusufziyrek.BookStoreManagement.dataAcces.IBookRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookServiceRules {

	private IBookRepository bookRepository;

	public void checkIfBookNameExists(String name) {
		if (this.bookRepository.existsByName(name)) {
			throw new RuntimeException("Book name already exists !!");

		}

	}

	public void checkIfFieldsNull(String name, String author, double price) {
		if (name.isBlank() || author.isBlank() || isNumeric(author) || price <= 0) {
			throw new RuntimeException("Invalid value !!");

		}

	}

	private boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
