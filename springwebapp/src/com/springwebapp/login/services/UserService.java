package com.springwebapp.login.services;

import java.util.List;

import com.springwebapp.login.vo.User;



public interface UserService {

	User getUserByUserName(String userName);

	List<String> getAuthoritiesByUserName(String userName);
}
