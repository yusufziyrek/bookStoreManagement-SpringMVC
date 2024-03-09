package com.yusufziyrek.BookStoreManagement.services.concretes;

import org.springframework.stereotype.Service;

import com.yusufziyrek.BookStoreManagement.dataAcces.IContactRepository;
import com.yusufziyrek.BookStoreManagement.dto.requests.CreatContactDto;
import com.yusufziyrek.BookStoreManagement.entities.Contact;
import com.yusufziyrek.BookStoreManagement.services.abstracts.IContactService;
import com.yusufziyrek.BookStoreManagement.services.rules.ContactServiceRules;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ContactManager implements IContactService {

	private IContactRepository contactRepository;
	private ContactServiceRules contactServiceRules;

	@Override
	public void add(CreatContactDto creatContactDto) {

		this.contactServiceRules.checkIfFieldsNull(creatContactDto.getUserName(), creatContactDto.getUserEmail(),
				creatContactDto.getMessage());

		this.contactServiceRules.checkIfMessageExists(creatContactDto.getMessage());

		Contact contact = new Contact();
		contact.setUserName(creatContactDto.getUserName());
		contact.setUserEmail(creatContactDto.getUserEmail());
		contact.setMessage(creatContactDto.getMessage());

		this.contactRepository.save(contact);

	}

}
