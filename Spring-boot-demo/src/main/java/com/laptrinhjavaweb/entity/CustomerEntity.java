package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerEntity extends BaseEntity{
	
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
	
	
	@ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;
	
	
	@OneToMany(mappedBy = "customer")
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


	public RoleEntity getRole() {
		return role;
	}


	public void setRole(RoleEntity role) {
		this.role = role;
	}


	public List<OrdersEntity> getOrders() {
		return orders;
	}


	public void setOrders(List<OrdersEntity> orders) {
		this.orders = orders;
	}
	
	
}
