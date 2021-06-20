package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderdetail")
public class OrderDetailEntity extends BaseEntity{
		
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "amount")
	private int amount;
	
	@ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;
	
	@ManyToOne
    @JoinColumn(name = "orders_code")
    private OrdersEntity orders;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public OrdersEntity getOrders() {
		return orders;
	}

	public void setOrders(OrdersEntity orders) {
		this.orders = orders;
	}
	
	
	
}
