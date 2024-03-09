package com.yusufziyrek.BookStoreManagement.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yusufziyrek.BookStoreManagement.dto.requests.BookAddDto;
import com.yusufziyrek.BookStoreManagement.dto.requests.BookUpdateDto;
import com.yusufziyrek.BookStoreManagement.dto.responses.BookListDto;
import com.yusufziyrek.BookStoreManagement.entities.Book;
import com.yusufziyrek.BookStoreManagement.services.abstracts.IBookService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {

	private IBookService bookService;

	@GetMapping
	public String getAll(Model model) {
		List<BookListDto> books = this.bookService.getAll();
		model.addAttribute("books", books);
		return "books";

	}

	@GetMapping("/add")
	public String addBook() {
		return "addBook";
	}

	@PostMapping("/add")
	public String addBook(@ModelAttribute BookAddDto bookAddDto) {
		this.bookService.add(bookAddDto);
		return "redirect:/books";

	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model model) {
		Book book = this.bookService.getById(id);
		model.addAttribute("book", book);

		return "editBook";

	}

	@PostMapping("/edit/{id}")
	public String edit(@ModelAttribute BookUpdateDto bookUpdateDto) {
		this.bookService.update(bookUpdateDto);
		return "redirect:/books";

	}

	@PostMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		this.bookService.delete(id);
		return "redirect:/books";
	}

}
