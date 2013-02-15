package com.springapp.login.services;

import java.util.List;

import com.springapp.login.vo.User;



public interface UserService {

	User getUserByUserName(String userName);

	List<String> getAuthoritiesByUserName(String userName);
}
