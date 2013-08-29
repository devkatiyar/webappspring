package com.springsecurity.dao;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.springsecurity.model.User;

public class UserDao {
	Logger logger = Logger.getLogger(this.getClass());

	@Resource
	SessionFactory sessionFactory;

	public User getUser(String userName) {
		
		
		logger.info("getUser called");
		Session session = null;
		try{
		session = sessionFactory.openSession();
		Criteria criteria =session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userName", userName));
		User user = (User)criteria.uniqueResult();
		
		//User user = (User) session.createCriteria(User.class).add(Restrictions.eq("userName", userName)).uniqueResult();
		return user;
		}catch (Exception e) {
		e.printStackTrace();
		return null;
		}
		
		/*
		logger.info("getUser called");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq("username", userName));
			User user =(User) criteria.uniqueResult();
			
		//	User user = (User) session.createCriteria(User.class)
			//		.add(Restrictions.eq("userName", userName)).uniqueResult();
			
			logger.info("user dao "+user);
			
			
		
			
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		*/
	}
}