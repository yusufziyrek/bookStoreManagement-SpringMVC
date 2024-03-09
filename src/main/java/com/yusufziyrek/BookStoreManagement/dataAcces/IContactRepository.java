package com.yusufziyrek.BookStoreManagement.dataAcces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yusufziyrek.BookStoreManagement.entities.Contact;

@Repository
public interface IContactRepository extends JpaRepository<Contact, Integer> {

	boolean existsByMessage(String message);

}
