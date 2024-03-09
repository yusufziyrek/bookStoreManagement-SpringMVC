package com.yusufziyrek.BookStoreManagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.yusufziyrek.BookStoreManagement.dto.requests.CreatContactDto;
import com.yusufziyrek.BookStoreManagement.services.abstracts.IContactService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BaseController {

	private IContactService contactService;

	@GetMapping({ "/", "", "/home" })
	public String getHome() {
		return "home";

	}

	@GetMapping("/about")
	public String getAbout() {
		return "about";

	}

	@GetMapping("/contact")
	public String getContact() {
		return "contact";

	}

	@PostMapping("/contact")
	public void getContact(@ModelAttribute CreatContactDto creatContactDto) {
		this.contactService.add(creatContactDto);
		System.out.println("New message !!");

	}
}