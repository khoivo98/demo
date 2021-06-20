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
@Table(name = "orders")
public class OrdersEntity extends BaseEntity{
	
	@Column(name = "code")
	private String code;
	
	
	@Column(name = "totalamount")
	private Long totalAmount;
	
	@ManyToOne
    @JoinColumn(name = "staff_id")
    private StaffEntity staff;
	
	@ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

	
	@OneToMany(mappedBy = "orders")
	private List<OrderDetailEntity> orderdetails = new ArrayList<>();
	
	
	
	public Long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
	}

	public StaffEntity getStaff() {
		return staff;
	}

	public void setStaff(StaffEntity staff) {
		this.staff = staff;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public List<OrderDetailEntity> getOrderdetails() {
		return orderdetails;
	}

	public void setOrderdetails(List<OrderDetailEntity> orderdetails) {
		this.orderdetails = orderdetails;
	}
	

}
