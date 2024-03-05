package com.yusufziyrek.BookStoreManagement.dataAcces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yusufziyrek.BookStoreManagement.entities.Book;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {

	boolean existsByName(String name);

}
