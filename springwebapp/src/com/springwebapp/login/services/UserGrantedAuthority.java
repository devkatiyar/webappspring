package com.springwebapp.login.services;

import org.springframework.security.core.GrantedAuthority;

public class UserGrantedAuthority implements GrantedAuthority {

	private String authority = null;

	public UserGrantedAuthority(String auth) {
		authority = auth;
	}

	public String getAuthority() {
		return authority;
	}

}
