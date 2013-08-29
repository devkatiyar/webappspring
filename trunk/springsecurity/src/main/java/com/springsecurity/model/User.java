package com.springsecurity.model;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
 
@Entity
@Table(name="user")
public class User {
@Id
@GeneratedValue
@Column(name="user_id")
private Integer userId;
 
@Column(name="user_name")
private String userName;
 
@Column(name="password")
private String password;
 
@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
@JoinTable(name = "user_role", joinColumns = {
@JoinColumn(name = "USER_ID", nullable = false, updatable = false) },
inverseJoinColumns = { @JoinColumn(name = "ROLE_ID",
nullable = false, updatable = false) })
 
private Set<Role> userRoles = new HashSet<Role>(0);
 
public Integer getUserId() {
return userId;
}
public void setUserId(Integer userId) {
this.userId = userId;
}
public String getUserName() {
return userName;
}
public void setUserName(String userName) {
this.userName = userName;
}
public String getPassword() {
return password;
}
public void setPassword(String password) {
this.password = password;
}
public Set<Role> getUserRoles() {
return userRoles;
}
public void setUserRoles(Set<Role> userRoles) {
this.userRoles = userRoles;
}
}
