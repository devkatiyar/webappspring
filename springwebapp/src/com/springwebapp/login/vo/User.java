package com.springwebapp.login.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {

	@Id
	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "ENABLED")
	private Boolean enabled;
	
	@Column(name = "ROLE")
	private String role;
	
	@Column(name = "EMAIL")
	private String email;

	public User() {
	}

	public User(String username, String password, Boolean isEnabled, String role, String email) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = isEnabled;
		this.role = role;
		this.email = email;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the isEnabled
	 */
	public Boolean getEnabled() {
		return enabled;
	}

	/**
	 * @param isEnabled
	 *            the isEnabled to set
	 */
	public void setEnabled(Boolean isEnabled) {
		this.enabled = isEnabled;
	}

	/**
	 * @return the roles
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param roles
	 *            the roles to set
	 */
	public void setRole(String roles) {
		this.role = roles;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param emailAddress
	 *            the emailAddress to set
	 */
	public void setEmail(String emailAddress) {
		this.email = emailAddress;
	}
}
