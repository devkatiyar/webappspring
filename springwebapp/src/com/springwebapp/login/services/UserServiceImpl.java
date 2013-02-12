package com.springwebapp.login.services;

import java.util.List;

import com.springwebapp.login.dao.UserDao;
import com.springwebapp.login.vo.User;




public class UserServiceImpl implements UserService {
	
	UserDao userDao;

	@Override
	public User getUserByUserName(String userName) {
		return userDao.getUserByUserName(userName);
	}

	@Override
	public List<String> getAuthoritiesByUserName(String userName) {
		return userDao.getAuthoritiesByUserName(userName);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
