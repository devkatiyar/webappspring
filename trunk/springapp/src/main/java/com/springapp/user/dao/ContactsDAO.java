package com.springapp.user.dao;

import java.util.List;

import com.springapp.user.vo.Contact;



public interface ContactsDAO {
	public Contact getById(int id);

	public List<Contact> searchContacts(String name);

	public List<Contact> getAllContacts();

	public int save(Contact contact);

	public void update(Contact contact);

	public void delete(int id);
	
	
}
