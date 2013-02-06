package com.springwebapp.login.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springwebapp.login.vo.User;



/**
 * The Class UserLoginDAOImpl
 */

@Transactional
public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;

	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public User getUserByUserName(String userName) {
		List<User> user = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq("username", userName));
			user = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (user.size() == 1) {
			return user.get(0);
		} else {
			return null;
		}
	}

}
