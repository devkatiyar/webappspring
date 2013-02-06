package com.springwebapp.login.dao;



import java.util.List;

import com.springwebapp.login.vo.User;

public interface UserDao {
	
	public User getUserByUserName(String userName);
}
