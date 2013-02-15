package com.springapp.user.services;

import java.util.List;

import com.springapp.user.vo.Contact;

public interface UserService {
	
	public Contact getById(int id);

	public List<Contact> searchContacts(String name);

	public List<Contact> getAllContacts();

	public int save(Contact contact);

	public void update(Contact contact);

	public void delete(int id);

}
