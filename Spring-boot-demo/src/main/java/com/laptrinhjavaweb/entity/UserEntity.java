package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

	@Column(name = "username")
	private String userName;

	@Column(name = "fullname")
	private String fullName;
	
	
	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@Column
	private Integer status;
	
	
	@ManyToMany( fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", 
				joinColumns = @JoinColumn(name = "user_id",referencedColumnName="id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName="id"))
	private List<RoleEntity> roles = new ArrayList<>();

	
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


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	


	public List<RoleEntity> getRoles() {
		return roles;
	}


	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}


	public void addRole(RoleEntity role) {
		this.roles.add(role);
	}

	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	
	
}