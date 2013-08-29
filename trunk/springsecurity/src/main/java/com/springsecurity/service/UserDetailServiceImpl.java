package com.springsecurity.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.springsecurity.dao.UserDao;
import com.springsecurity.model.Role;

@SuppressWarnings("deprecation")
public class UserDetailServiceImpl implements UserDetailsService {

	Logger logger = Logger.getLogger(getClass());

	@Autowired
	UserDao userDao;

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		try {
			logger.info("loadUserByUsername ");

			com.springsecurity.model.User userFromDB = userDao
					.getUser(username);
			logger.info("got user from database " + userFromDB);
			List<GrantedAuthorityImpl> authorities = new ArrayList<GrantedAuthorityImpl>();
			logger.info("");
			logger.info("userFromDB.getUserRoles()"+userFromDB.getUserRoles());
			for (Role role : userFromDB.getUserRoles()) {
				authorities.add(new GrantedAuthorityImpl(role.getRoleName()));
			}

			UserDetails user = new User(userFromDB.getUserName(),
					userFromDB.getPassword(), true, true, true, true,
					authorities);

			return user;
		} catch (Exception e) {
			logger.error("error " + e);
			return null;
		}
	}
}