package com.springwebapp.login.services;

import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.springwebapp.login.services.UserService;
import com.springwebapp.login.dao.UserDao;
import com.springwebapp.login.vo.User;

public class UserUserDetailsService implements UserDetailsService {
	private UserService userService;
	public UserUserDetailsService(UserService userService) {
		this.userService = userService;
	}
	
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException, DataAccessException {
		User user;
		try {
			user = userService.getUserByUserName(userName);
			List<String> authorities = userService.getAuthoritiesByUserName(userName);
			user.setUserAuthorities(authorities);
			Collection<GrantedAuthority> grantedAuthority = user.getAuthorities();
			Object a[] = grantedAuthority.toArray();
			GrantedAuthority authority = new UserGrantedAuthority(a[0].toString());
			CustomUser customUser = new CustomUser(user.getUsername(),user.getPassword(), new GrantedAuthority[] { authority });
			return customUser;

		} catch (Exception e) {
			throw new UsernameNotFoundException(
					"getUserByUserName returned null.");
		}
	}
}
