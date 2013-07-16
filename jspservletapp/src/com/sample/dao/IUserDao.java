package com.sample.dao;

import java.util.List;

import com.sample.vo.User;

public interface IUserDao {
	public void addUser(User user);
	public void deleteUser(int userId);
	public void updateUser(User user);
	public List<User> getAllUsers();
	public User getUserById(int userId);

}
