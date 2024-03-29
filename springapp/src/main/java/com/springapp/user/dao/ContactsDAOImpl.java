package com.springapp.user.dao;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springapp.user.vo.Contact;





@Repository
@Transactional
public class ContactsDAOImpl implements ContactsDAO{
	@Autowired
	private SessionFactory sessionFactory;

	public Contact getById(int id) {
		return (Contact) sessionFactory.getCurrentSession().get(Contact.class,
				id);
	}

	@SuppressWarnings("unchecked")
	public List<Contact> searchContacts(String name) {
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(
				Contact.class);
		criteria.add(Restrictions.ilike("name", name + "%"));	
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Contact> getAllContacts() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Contact.class);
		return criteria.list();
	}

	public int save(Contact contact) {
		return (Integer) sessionFactory.getCurrentSession().save(contact);
	}

	public void update(Contact contact) {
		sessionFactory.getCurrentSession().merge(contact);
	}

	public void delete(int id) {
		Contact c = getById(id);
		sessionFactory.getCurrentSession().delete(c);
	}

}

