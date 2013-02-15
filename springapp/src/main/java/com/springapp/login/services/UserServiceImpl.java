package com.springapp.login.services;

import java.util.List;

import com.springapp.login.dao.UserDao;
import com.springapp.login.vo.User;

public class UserServiceImpl implements UserService {

	UserDao userDao;

	public User getUserByUserName(String userName) {
		return userDao.getUserByUserName(userName);
	}

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
