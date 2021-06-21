package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderdetail")
public class OrderDetailEntity extends BaseEntity{
		
	@Column(name = "quantity")
	private Long quantity;
	
	@Column(name = "amount")
	private Long amount;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductEntity product;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orders_code")
    private OrdersEntity orders;

	

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
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
