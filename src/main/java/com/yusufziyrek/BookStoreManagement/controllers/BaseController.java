package com.yusufziyrek.BookStoreManagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BaseController {

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
	public String getContact(@RequestParam String name, @RequestParam String email, @RequestParam String message) {

		System.out.println(name);
		System.out.println(email);
		System.out.println(message);
		return "redirect:/contact";
	}
}