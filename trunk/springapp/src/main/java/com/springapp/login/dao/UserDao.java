package com.springapp.login.dao;



import java.util.List;

import com.springapp.login.vo.User;

public interface UserDao {
	
	public User getUserByUserName(String userName);
	List<String> getAuthoritiesByUserName(String userName);
}
