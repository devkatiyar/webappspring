package com.springwebapp.login.services;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.springwebapp.login.dao.UserDao;
import com.springwebapp.login.vo.User;

public class UserUserDetailsService implements UserDetailsService {

	private UserDao userDao;

	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException, DataAccessException {
		User user;
		try {
			user = userDao.getUserByUserName(userName);
			GrantedAuthority grantedAuthority = new UserGrantedAuthority(user.getRole());
			CustomUser customUser = new CustomUser(user.getUsername(), user.getPassword(), new GrantedAuthority[] { grantedAuthority });
			return customUser;
		} catch (Exception e) {
			throw new UsernameNotFoundException("getUserByUserName returned null.");
		}
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
