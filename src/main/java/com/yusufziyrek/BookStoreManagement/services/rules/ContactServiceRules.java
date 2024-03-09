package com.yusufziyrek.BookStoreManagement.services.rules;

import org.springframework.stereotype.Service;

import com.yusufziyrek.BookStoreManagement.dataAcces.IContactRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ContactServiceRules {

	private IContactRepository contactRepository;

	public void checkIfFieldsNull(String userName, String userEmail, String message) {
		if (userName.isBlank() || userEmail.isBlank() || message.isBlank()) {
			throw new RuntimeException("Invalid value !!");

		}

	}

	public void checkIfMessageExists(String message) {
		if (this.contactRepository.existsByMessage(message)) {
			throw new RuntimeException("Message already exists !!");

		}

	}

}
