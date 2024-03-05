package com.yusufziyrek.BookStoreManagement.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.yusufziyrek.BookStoreManagement.dataAcces.IBookRepository;
import com.yusufziyrek.BookStoreManagement.dto.BookAddDto;
import com.yusufziyrek.BookStoreManagement.dto.BookListDto;
import com.yusufziyrek.BookStoreManagement.dto.BookUpdateDto;
import com.yusufziyrek.BookStoreManagement.entities.Book;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookManager implements IBookService {

	private IBookRepository bookRepository;

	@Override
	public List<BookListDto> getAll() {
		List<Book> list = bookRepository.findAll();
		List<BookListDto> dtoList = list.stream().map(book -> {
			BookListDto dto = new BookListDto();
			dto.setId(book.getId());
			dto.setName(book.getName());
			dto.setAuthor(book.getAuthor());
			dto.setPrice(book.getPrice());
			return dto;
		}).collect(Collectors.toList());
		return dtoList;

	}

	@Override
	public Book getById(int id) {
		Book book = this.bookRepository.findById(id).orElseThrow();
		return book;
	}

	@Override
	public void add(BookAddDto bookAddDto) {

		Book book = new Book();
		book.setName(bookAddDto.getName());
		book.setAuthor(bookAddDto.getAuthor());
		book.setPrice(bookAddDto.getPrice());

		this.bookRepository.save(book);

	}

	@Override
	public void update(BookUpdateDto bookUpdateDto) {
		Book book = this.bookRepository.findById(bookUpdateDto.getId()).orElseThrow();
		book.setName(bookUpdateDto.getName());
		book.setAuthor(bookUpdateDto.getAuthor());
		book.setPrice(bookUpdateDto.getPrice());

		this.bookRepository.save(book);

	}

	@Override
	public void delete(int id) {
		this.bookRepository.deleteById(id);

	}

}
