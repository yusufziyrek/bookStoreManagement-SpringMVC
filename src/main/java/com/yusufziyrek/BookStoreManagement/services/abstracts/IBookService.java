package com.yusufziyrek.BookStoreManagement.services.abstracts;

import java.util.List;

import com.yusufziyrek.BookStoreManagement.dto.requests.BookAddDto;
import com.yusufziyrek.BookStoreManagement.dto.requests.BookUpdateDto;
import com.yusufziyrek.BookStoreManagement.dto.responses.BookListDto;
import com.yusufziyrek.BookStoreManagement.entities.Book;

public interface IBookService {

	List<BookListDto> getAll();

	Book getById(int id);

	void add(BookAddDto bookDto);

	void update(BookUpdateDto bookUpdateDto);

	void delete(int id);

}
