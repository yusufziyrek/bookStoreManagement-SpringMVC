package com.yusufziyrek.BookStoreManagement.services;

import java.util.List;

import com.yusufziyrek.BookStoreManagement.dto.BookAddDto;
import com.yusufziyrek.BookStoreManagement.dto.BookListDto;
import com.yusufziyrek.BookStoreManagement.dto.BookUpdateDto;
import com.yusufziyrek.BookStoreManagement.entities.Book;

public interface IBookService {

	List<BookListDto> getAll();

	Book getById(int id);

	void add(BookAddDto bookDto);

	void update(BookUpdateDto bookUpdateDto);

	void delete(int id);

}
