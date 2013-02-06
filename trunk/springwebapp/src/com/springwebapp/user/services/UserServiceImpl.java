package com.springwebapp.user.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springwebapp.user.dao.ContactsDAO;
import com.springwebapp.user.vo.Contact;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	public ContactsDAO contactsDAO;

	public Contact getById(int id) {
		return contactsDAO.getById(id);
	}

	public List<Contact> searchContacts(String name) {

		return contactsDAO.searchContacts(name);
	}

	public List<Contact> getAllContacts() {

		return contactsDAO.getAllContacts();
	}

	public int save(Contact contact) {
		return contactsDAO.save(contact);
	}

	public void update(Contact contact) {
		contactsDAO.update(contact);
	}

	public void delete(int id) {
		contactsDAO.delete(id);
	}
}
