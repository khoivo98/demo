package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "staff")
public class StaffEntity extends BaseEntity {

	@Column(name = "username")
	private String userName;

	@Column
	private String password;

	@Column(name = "fullname")
	private String fullName;
	
	@Column(name = "address")
	private String addRess;
	
	@Column(name = "phone")
	private Long phone;
	
	@Column(name = "salary")
	private Long salary;
	
	
	@Column
	private Integer status;

	@ManyToMany
	@JoinTable(name = "staff_role", 
				joinColumns = @JoinColumn(name = "staff_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<RoleEntity> roles = new ArrayList<>();

	
	public List<OrdersEntity> getOrders() {
		return orders;
	}

	public void setOrders(List<OrdersEntity> orders) {
		this.orders = orders;
	}

	@OneToMany(mappedBy = "staff")
	private List<OrdersEntity> orders = new ArrayList<>();
	
	
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public String getAddRess() {
		return addRess;
	}

	public void setAddRess(String addRess) {
		this.addRess = addRess;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}


	
}